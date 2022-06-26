using Equipments.Domain.Commands;
using Equipments.Domain.Handler;
using Equipments.Domain.Repositories;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Equipments.Api.Controllers
{
    [ApiController]
    public class EquipmentModelController : ControllerBase
    {
        [HttpGet("equipment-model")]
        public async Task<IActionResult> Get([FromServices] IEquipmentModelRepository repository) 
        {
            var equipmentModels = await repository.GetAllAsync();

            if (equipmentModels.Count() == 0)
                return Ok(new GenericCommandResult(true, "Você ainda não tem modelos de equipamento registrados", null));

            return Ok(new GenericCommandResult(true, "Seus modelos de equipamento", equipmentModels));
        }
        [HttpGet("equipment-model/{id:Guid}")]
        public async Task<IActionResult> GetById([FromServices] IEquipmentModelRepository repository, [FromRoute] Guid id) 
        {
            var equipmentModel = await repository.GetByIdAsync(id);

            if (equipmentModel == null)
                return NotFound(new GenericCommandResult(false, "Modelo de equipamento não encontrado", null));

            return Ok(new GenericCommandResult(true, "Seu modelo de equipamento", equipmentModel));
        }
        [HttpPost("equipment-model/create")]
        public async Task<IActionResult> Post([FromBody] CreateEquipmentModelCommand command, [FromServices] Handler handler) 
        {
            if (command == null)
                return BadRequest(new GenericCommandResult(false, "Dados inválidos", null));

            try
            {
                await handler.Handle(command);
                return Ok(new GenericCommandResult(true, "Modelo de equipamento registrado com sucesso", command));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "Falha interna no servidor", null));
            }
        }
        [HttpPut("equipment-model/update/{id:Guid}")]
        public async Task<IActionResult> Put([FromServices] IEquipmentModelRepository repository,[FromBody] string name, [FromRoute] Guid id) 
        {
            var equipmentModel = await repository.GetByIdAsync(id);

            if (equipmentModel == null)
                return NotFound(new GenericCommandResult(false, "Modelo de equipamento não encontrado", null));
            try
            {
                equipmentModel.EditName(name);
                await repository.UpdateAsync(equipmentModel);
                return Ok(new GenericCommandResult(true, "Modelo de equipamento atualizado com suceesso", equipmentModel));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "Falha interna no servidor", null));
            }
        }
        [HttpDelete("equipment-model/delete/{id:Guid}")]
        public async Task<IActionResult> Delete([FromServices] IEquipmentModelRepository repository, [FromRoute] Guid id) 
        {
            var equipmentModel = await repository.GetByIdAsync(id);

            if (equipmentModel == null)
                return NotFound(new GenericCommandResult(false, "Modelo de equipamento não encontrado", null));

            try
            {
                await repository.DeleteAsync(equipmentModel);
                return Ok(new GenericCommandResult(true, "Modelo de equipamento deletado com sucesso", null));
            }
            catch (Exception)
            {
                return StatusCode(500, new GenericCommandResult(false, "Falha interna no servidor", null)); ;
            }
        }
    }
}
