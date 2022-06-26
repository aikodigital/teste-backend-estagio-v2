using Equipments.Domain.Commands;
using Equipments.Domain.Repositories;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Equipments.Api.Controllers
{
    [ApiController]
    public class EquipmentPositionHistoryController : ControllerBase
    {
        [HttpGet("equipment-position-history")]
        public async Task<IActionResult> Get([FromServices] IEquipmentPositionHistoryRepository repository) 
        {
            var positionHistory = await repository.GetAllAsync();

            return Ok(new GenericCommandResult(true, "Histórico de posições", positionHistory));
        }
        [HttpGet("equipment-position-history/{equipmentId:Guid}")]
        public async Task<IActionResult> GetById([FromServices] IEquipmentPositionHistoryRepository repository, [FromRoute] Guid id) 
        {
            var positionHistoryById = await repository.GetByIdAsync(id);

            return Ok(new GenericCommandResult(true, "Histórico de posições", null));
        }
    }
}
