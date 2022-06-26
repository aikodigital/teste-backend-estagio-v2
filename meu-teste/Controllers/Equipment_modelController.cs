using Microsoft.AspNetCore.Mvc;
using equipment_model.Model;
using equipment_model.Repository;

namespace equipment_model.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class Equipment_modelController : ControllerBase
    {
        private readonly IEquipment_modelRepository _repository;

        public Equipment_modelController(IEquipment_modelRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var equipment_models = await _repository.BuscaEquipment_models();
            return equipment_models.Any()
                    ? Ok(equipment_models)
                    : NoContent();
        }
        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(Guid id)
        {
            var equipment_model = await _repository.BuscaEquipment_model(id);
            return equipment_model != null
                    ? Ok(equipment_model)
                    : NotFound("Modelo de equipamento não encontrado");
        }

        [HttpPost]
        public async Task<IActionResult> Post(Equipment_model equipment_model)
        {
            _repository.AdicionaEquipment_model(equipment_model);
            return await _repository.SaveChangesAsync()
                    ? Ok("Modelo de equipamento adicionado com sucesso")
                    : BadRequest("Erro ao salvar o modelo de equipamento");
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> Put(Guid id, Equipment_model equipment_model)
        {
            var equipment_modelBanco = await _repository.BuscaEquipment_model(id);
            if (equipment_modelBanco == null) return NotFound("Modelo de equipamento não encontrado");
        
            equipment_modelBanco.Name = equipment_model.Name ?? equipment_modelBanco.Name;

            _repository.AtualizaEquipment_model(equipment_modelBanco);

            return await _repository.SaveChangesAsync()
                    ? Ok("Modelo de equipamento atualizado com sucesso")
                    : BadRequest("Erro ao atualizar o modelo de equipamento");
        
        }

        [HttpDelete]
        public async Task<IActionResult> Delete(Guid id)
        {
            var equipment_modelBanco = await _repository.BuscaEquipment_model(id);
            if (equipment_modelBanco == null) return NotFound("Modelo de quipamento não encontrado");

            _repository.DeletaEquipment_model(equipment_modelBanco);

            return await _repository.SaveChangesAsync()
                        ? Ok("Modelo de equipamento deletado com sucesso")
                        : BadRequest("Erro ao deletar o modelo de equipamento");

        }

    }
}