using Microsoft.AspNetCore.Mvc;
using equipment_model_state_hourly_earnings.Model;
using equipment_model_state_hourly_earnings.Repository;

namespace equipment_model_state_hourly_earnings.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class Equipment_model_state_hourly_earningsController : ControllerBase
    {
        private readonly IEquipment_model_state_hourly_earningsRepository _repository;

        public Equipment_model_state_hourly_earningsController(IEquipment_model_state_hourly_earningsRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var equipment_model_state_hourly_earningss = await _repository.BuscaEquipment_model_state_hourly_earningss();
            return equipment_model_state_hourly_earningss.Any()
                    ? Ok(equipment_model_state_hourly_earningss)
                    : NoContent();
        }
        [HttpGet("{equipment_model_id}&{equipment_state_id}")]
        public async Task<IActionResult> GetById(int equipment_model_id, int equipment_state_id)
        {
            var equipment_model_state_hourly_earnings = await _repository.BuscaEquipment_model_state_hourly_earnings(equipment_model_id, equipment_state_id);
            return equipment_model_state_hourly_earnings != null
                    ? Ok(equipment_model_state_hourly_earnings)
                    : NotFound("Ganhos por hora do modelo de equipamento no estado não encontrado");
        }

        [HttpPost]
        public async Task<IActionResult> Post(Equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings)
        {
            _repository.AdicionaEquipment_model_state_hourly_earnings(equipment_model_state_hourly_earnings);
            return await _repository.SaveChangesAsync()
                    ? Ok("Ganhos por hora do modelo de equipamento no estado adicionado com sucesso")
                    : BadRequest("Erro ao salvar o ganhos por hora do modelo de equipamento no estado");
        }

        [HttpPut("{equipment_model_id}&{equipment_state_id}")]
        public async Task<IActionResult> Put(int equipment_model_id, int equipment_state_id, Equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings)
        {
            var equipment_model_state_hourly_earningsBanco = await _repository.BuscaEquipment_model_state_hourly_earnings(equipment_model_id, equipment_state_id);
            if (equipment_model_state_hourly_earningsBanco == null) return NotFound("Ganhos por hora do modelo de equipamento no estado não encontrado");
        
            equipment_model_state_hourly_earningsBanco.Equipment_model_id = equipment_model_state_hourly_earnings.Equipment_model_id;
            equipment_model_state_hourly_earningsBanco.Equipment_state_id = equipment_model_state_hourly_earnings.Equipment_state_id;
            equipment_model_state_hourly_earningsBanco.Value = equipment_model_state_hourly_earnings.Value;

            _repository.AtualizaEquipment_model_state_hourly_earnings(equipment_model_state_hourly_earningsBanco);

            return await _repository.SaveChangesAsync()
                    ? Ok("Ganhos por hora do modelo de equipamento no estado atualizado com sucesso")
                    : BadRequest("Erro ao atualizar o ganhos por hora do modelo de equipamento no estado");
        
        }

        [HttpDelete]
        public async Task<IActionResult> Delete(int equipment_id, int equipment_state_id)
        {
            var equipment_model_state_hourly_earningsBanco = await _repository.BuscaEquipment_model_state_hourly_earnings(equipment_id, equipment_state_id);
            if (equipment_model_state_hourly_earningsBanco == null) return NotFound("Estado de quipamento não encontrado");

            _repository.DeletaEquipment_model_state_hourly_earnings(equipment_model_state_hourly_earningsBanco);

            return await _repository.SaveChangesAsync()
                        ? Ok("Ganhos por hora do modelo de equipamento no estado deletado com sucesso")
                        : BadRequest("Erro ao deletar o ganhos por hora do modelo de equipamento no estado");

        }

    }
}