using Microsoft.AspNetCore.Mvc;
using equipment_state.Model;
using equipment_state.Repository;

namespace equipment_state.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class Equipment_stateController : ControllerBase
    {
        private readonly IEquipment_stateRepository _repository;

        public Equipment_stateController(IEquipment_stateRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var equipment_states = await _repository.BuscaEquipment_states();
            return equipment_states.Any()
                    ? Ok(equipment_states)
                    : NoContent();
        }
        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id)
        {
            var equipment_state = await _repository.BuscaEquipment_state(id);
            return equipment_state != null
                    ? Ok(equipment_state)
                    : NotFound("Estado de equipamento não encontrado");
        }

        [HttpPost]
        public async Task<IActionResult> Post(Equipment_state equipment_state)
        {
            _repository.AdicionaEquipment_state(equipment_state);
            return await _repository.SaveChangesAsync()
                    ? Ok("Estado de equipamento adicionado com sucesso")
                    : BadRequest("Erro ao salvar o estado de equipamento");
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> Put(int id, Equipment_state equipment_state)
        {
            var equipment_stateBanco = await _repository.BuscaEquipment_state(id);
            if (equipment_stateBanco == null) return NotFound("Estado de equipamento não encontrado");
        
            equipment_stateBanco.Name = equipment_state.Name ?? equipment_stateBanco.Name;
            equipment_stateBanco.Name = equipment_state.Color ?? equipment_stateBanco.Color;

            _repository.AtualizaEquipment_state(equipment_stateBanco);

            return await _repository.SaveChangesAsync()
                    ? Ok("Estado de equipamento atualizado com sucesso")
                    : BadRequest("Erro ao atualizar o estado de equipamento");
        
        }

        [HttpDelete]
        public async Task<IActionResult> Delete(int id)
        {
            var equipment_stateBanco = await _repository.BuscaEquipment_state(id);
            if (equipment_stateBanco == null) return NotFound("Estado de quipamento não encontrado");

            _repository.DeletaEquipment_state(equipment_stateBanco);

            return await _repository.SaveChangesAsync()
                        ? Ok("Estado de equipamento deletado com sucesso")
                        : BadRequest("Erro ao deletar o Estado de equipamento");

        }

    }
}