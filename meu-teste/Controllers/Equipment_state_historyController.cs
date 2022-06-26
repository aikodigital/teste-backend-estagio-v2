using Microsoft.AspNetCore.Mvc;
using equipment_state_history.Model;
using equipment_state_history.Repository;

namespace equipment_state_history.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class Equipment_state_historyController : ControllerBase
    {
        private readonly IEquipment_state_historyRepository _repository;

        public Equipment_state_historyController(IEquipment_state_historyRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var equipment_state_historys = await _repository.BuscaEquipment_state_historys();
            return equipment_state_historys.Any()
                    ? Ok(equipment_state_historys)
                    : NoContent();
        }
        [HttpGet("{equipment_model_id}&{equipment_state_id}")]
        public async Task<IActionResult> GetById(Guid equipment_model_id, Guid equipment_state_id)
        {
            var equipment_state_history = await _repository.BuscaEquipment_state_history(equipment_model_id, equipment_state_id);
            return equipment_state_history != null
                    ? Ok(equipment_state_history)
                    : NotFound("Histórico de estado de equipamento não encontrado");
        }

        [HttpPost]
        public async Task<IActionResult> Post(Equipment_state_history equipment_state_history)
        {
            _repository.AdicionaEquipment_state_history(equipment_state_history);
            return await _repository.SaveChangesAsync()
                    ? Ok("Histórico de estado de equipamento adicionado com sucesso")
                    : BadRequest("Erro ao salvar o histórico de estado de equipamento");
        }

        [HttpPut("{equipment_model_id}&{equipment_state_id}")]
        public async Task<IActionResult> Put(Guid equipment_model_id, Guid equipment_state_id, Equipment_state_history equipment_state_history)
        {
            var equipment_state_historyBanco = await _repository.BuscaEquipment_state_history(equipment_model_id, equipment_state_id);
            if (equipment_state_historyBanco == null) return NotFound("Histórico de estado de equipamento não encontrado");
        
            equipment_state_historyBanco.Equipment_id = equipment_state_history.Equipment_id;
            equipment_state_historyBanco.Equipment_state_id = equipment_state_history.Equipment_state_id;
            equipment_state_historyBanco.Date = equipment_state_history.Date != new DateTime()
            ? equipment_state_history.Date : equipment_state_historyBanco.Date;

            _repository.AtualizaEquipment_state_history(equipment_state_historyBanco);

            return await _repository.SaveChangesAsync()
                    ? Ok("Histórico de estado de equipamento atualizado com sucesso")
                    : BadRequest("Erro ao atualizar o histórico de estado de equipamento");
        
        }

        [HttpDelete]
        public async Task<IActionResult> Delete(Guid equipment_id, Guid equipment_state_id)
        {
            var equipment_state_historyBanco = await _repository.BuscaEquipment_state_history(equipment_id, equipment_state_id);
            if (equipment_state_historyBanco == null) return NotFound("Estado de quipamento não encontrado");

            _repository.DeletaEquipment_state_history(equipment_state_historyBanco);

            return await _repository.SaveChangesAsync()
                        ? Ok("Estado de equipamento deletado com sucesso")
                        : BadRequest("Erro ao deletar o Estado de equipamento");

        }

    }
}