using Equipments.Domain.Commands;
using Equipments.Domain.Handler;
using Equipments.Domain.Repositories;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Equipments.Api.Controllers
{
    [ApiController]
    public class EquipmentStateController : ControllerBase
    {
        [HttpGet("equipment-state")]
        public async Task<IActionResult> Get([FromServices] IEquipmentStateRepository repository)
        {
            var equipmentStates = await repository.GetAllAsync();

            if (equipmentStates.Count() == 0)
                return Ok(new GenericCommandResult(true, "Você ainda não tem estados de equipamento registrados", null));

            return Ok(new GenericCommandResult(true, "Seus estados de equipamento", equipmentStates));
        }
        [HttpGet("equipment-state/{id:Guid}")]
        public async Task<IActionResult> GetById([FromServices] IEquipmentStateRepository repository, [FromRoute] Guid id)
        {
            var equipmentState = await repository.GetByIdAsync(id);

            if (equipmentState == null)
                return NotFound(new GenericCommandResult(false, "Estado de equipamento não encontrado", null));

            return Ok(new GenericCommandResult(true, "Seu estado de equipamento", equipmentState));
        }
        [HttpPost("equipment-state/create")]
        public async Task<IActionResult> Post([FromBody] CreateEquipmentStateCommand command, [FromServices] Handler handler)
        {
            if (command == null)
                return BadRequest(new GenericCommandResult(false, "Dados inválidos", null));

            try
            {
                await handler.Handle(command);
                return Ok(new GenericCommandResult(true, "Estado de equipamento registrado com sucesso", command));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "Falha interna no servidor", null));
            }
        }
        [HttpPut("equipment-state/update/{id:Guid}")]
        public async Task<IActionResult> Put([FromServices] IEquipmentStateRepository repository, [FromBody] string name, [FromRoute] Guid id)
        {
            var equipmentState = await repository.GetByIdAsync(id);

            if (equipmentState == null)
                return NotFound(new GenericCommandResult(false, "Estado de equipamento não encontrado", null));
            try
            {
                equipmentState.EditName(name);
                await repository.UpdateAsync(equipmentState);
                return Ok(new GenericCommandResult(true, "Estado de equipamento atualizado com suceesso", equipmentState));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "Falha interna no servidor", null));
            }
        }
        [HttpDelete("equipment-state/delete/{id:Guid}")]
        public async Task<IActionResult> Delete([FromServices] IEquipmentStateRepository repository, [FromRoute] Guid id)
        {
            var equipmentState = await repository.GetByIdAsync(id);

            if (equipmentState == null)
                return NotFound(new GenericCommandResult(false, "Modelo de equipamento não encontrado", null));

            try
            {
                await repository.DeleteAsync(equipmentState);
                return Ok(new GenericCommandResult(true, "Modelo de equipamento deletado com sucesso", null));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "Falha interna no servidor", null)); ;
            }
        }
    }
}
