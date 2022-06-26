using Microsoft.AspNetCore.Mvc;
using equipment_position_history.Model;
using equipment_position_history.Repository;

namespace equipment_position_history.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class Equipment_position_historyController : ControllerBase
    {
        private readonly IEquipment_position_historyRepository _repository;

        public Equipment_position_historyController(IEquipment_position_historyRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var equipment_position_historys = await _repository.BuscaEquipment_position_historys();
            return equipment_position_historys.Any()
                    ? Ok(equipment_position_historys)
                    : NoContent();
        }
        [HttpGet("{equipment_id}")]
        public async Task<IActionResult> GetById(Guid equipment_id)
        {
            var equipment_position_history = await _repository.BuscaEquipment_position_history(equipment_id);
            return equipment_position_history != null
                    ? Ok(equipment_position_history)
                    : NotFound("Histórico de posição de equipamento não encontrado");
        }

        [HttpPost]
        public async Task<IActionResult> Post(Equipment_position_history equipment_position_history)
        {
            _repository.AdicionaEquipment_position_history(equipment_position_history);
            return await _repository.SaveChangesAsync()
                    ? Ok("Histórico de posição de equipamento adicionado com sucesso")
                    : BadRequest("Erro ao salvar o histórico de posição de equipamento");
        }

        [HttpPut("{equipment_id}")]
        public async Task<IActionResult> Put(Guid equipment_id, Equipment_position_history equipment_position_history)
        {
            var equipment_position_historyBanco = await _repository.BuscaEquipment_position_history(equipment_id);
            if (equipment_position_historyBanco == null) return NotFound("Histórico de posição de equipamento não encontrado");
        
            equipment_position_historyBanco.Equipment_id = equipment_position_history.Equipment_id;
            equipment_position_historyBanco.Date = equipment_position_history.Date != new DateTime()
            ? equipment_position_history.Date : equipment_position_historyBanco.Date;
            equipment_position_historyBanco.Lat = equipment_position_history.Lat;
            equipment_position_historyBanco.Lon = equipment_position_history.Lon;

            _repository.AtualizaEquipment_position_history(equipment_position_historyBanco);

            return await _repository.SaveChangesAsync()
                    ? Ok("Histórico de posição de equipamento atualizado com sucesso")
                    : BadRequest("Erro ao atualizar o histórico de posição de equipamento");
        
        }

        [HttpDelete]
        public async Task<IActionResult> Delete(Guid equipment_id)
        {
            var equipment_position_historyBanco = await _repository.BuscaEquipment_position_history(equipment_id);
            if (equipment_position_historyBanco == null) return NotFound("Histórico de posição de quipamento não encontrado");

            _repository.DeletaEquipment_position_history(equipment_position_historyBanco);

            return await _repository.SaveChangesAsync()
                        ? Ok("Histórico de posição de equipamento deletado com sucesso")
                        : BadRequest("Erro ao deletar o histórico de posição de equipamento");

        }

    }
}