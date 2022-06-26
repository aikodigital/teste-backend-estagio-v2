using Equipments.Domain.Commands;
using Equipments.Domain.Handler;
using Equipments.Domain.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace Equipments.Api.Controllers
{
    [ApiController]
    public class EquipmentController : ControllerBase
    {
        [HttpGet("equipments")]
        public async Task<IActionResult> Get([FromServices] IEquipmentRepository repository) 
        {
            var equipments =  await repository.GetAllAsync();

            if (equipments.Count() == 0)
                return Ok(new GenericCommandResult(true, "Você ainda não tem equipamentos registrados", null));

            return Ok(new GenericCommandResult(true, "Seus equipamentos", equipments));
        }
        [HttpGet("equipments/{id:Guid}")]
        public async Task<IActionResult> GetById([FromServices] IEquipmentRepository repository, [FromRoute] Guid id) 
        {
            var equipment = await repository.GetByIdAsync(id);

            if (equipment == null)
                return NotFound(new GenericCommandResult(false, "equipamento não encontrado", null));

            return Ok(new GenericCommandResult(true, "seu equipamento", equipment));
        }
        [HttpPost("equipments/create")]
        public async Task<IActionResult> Post([FromBody] CreateEquipmentCommand command, [FromServices] Handler handler) 
        {
            if (command == null)
                return BadRequest(new GenericCommandResult(false, "Dados inválidos", null));

            try
            {
                await handler.Handle(command);
                return Ok(new GenericCommandResult(true, "Equipamento Criado", command));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "Falha interna no servidor", null));
            }
        }
        [HttpPut("equipments/update/{id:Guid}")]
        public async Task<IActionResult> Put([FromServices] IEquipmentRepository repository, [FromBody] string name, [FromRoute] Guid id) 
        {
            var equipment = await repository.GetByIdAsync(id);

            if (equipment == null)
                return BadRequest(new GenericCommandResult(false, "Equipamento não encontrado", null));

            try
            {
                equipment.EditName(name);
                await repository.UpdateAsync(equipment);
                return Ok(new GenericCommandResult(true, "Nome do equipamento editado com sucesso", equipment));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "Falha interna no servidor", null));
            }
        }
        [HttpDelete("equipments/delete/{id:Guid}")]
        public async Task<IActionResult> Delete([FromServices] IEquipmentRepository repository, [FromRoute] Guid id) 
        {
            var equipment = await repository.GetByIdAsync(id);

            if (equipment == null)
                return BadRequest(new GenericCommandResult(false, "Equipamento não encontrado", null));

            try
            {
                await repository.DeleteAsync(equipment);
                return Ok(new GenericCommandResult(true, "Equipamento deletado com sucesso", null));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "falha interna no servidor", null));
            }
        }
    }
}
