using Microsoft.AspNetCore.Mvc;
using equipment.Model;
using equipment.Repository;

namespace equipment.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class EquipmentController : ControllerBase
    {
        private readonly IEquipmentRepository _repository;

        public EquipmentController(IEquipmentRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var equipments = await _repository.BuscaEquipments();
            return equipments.Any()
                    ? Ok(equipments)
                    : NoContent();
        }
        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(Guid id)
        {
            var equipment = await _repository.BuscaEquipment(id);
            return equipment != null
                    ? Ok(equipment)
                    : NotFound("Equipamento não encontrado");
        }

        [HttpPost]
        public async Task<IActionResult> Post(Equipment equipment)
        {
            _repository.AdicionaEquipment(equipment);
            return await _repository.SaveChangesAsync()
                    ? Ok("Equipamento adicionado com sucesso")
                    : BadRequest("Erro ao salvar o equipamento");
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> Put(Guid id, Equipment equipment)
        {
            var equipmentBanco = await _repository.BuscaEquipment(id);
            if (equipmentBanco == null) return NotFound("Equipamento não encontrado");
        
            equipmentBanco.Name = equipment.Name ?? equipmentBanco.Name;
            equipmentBanco.Equipment_model_id = equipment.Equipment_model_id;

            _repository.AtualizaEquipment(equipmentBanco);

            return await _repository.SaveChangesAsync()
                    ? Ok("Equipamento atualizado com sucesso")
                    : BadRequest("Erro ao atualizar o equipamento");
        
        }

        [HttpDelete]
        public async Task<IActionResult> Delete(Guid id)
        {
            var equipmentBanco = await _repository.BuscaEquipment(id);
            if (equipmentBanco == null) return NotFound("Equipamento não encontrado");

            _repository.DeletaEquipment(equipmentBanco);

            return await _repository.SaveChangesAsync()
                        ? Ok("Equipamento deletado com sucesso")
                        : BadRequest("Erro ao deletar o Equipamento");

        }

    }
}