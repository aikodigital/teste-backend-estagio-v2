using Equipments.Domain.Commands;
using Equipments.Domain.Repositories;

using Microsoft.AspNetCore.Mvc;

namespace Equipments.Api.Controllers
{
    [ApiController]
    public class EquipmentStateHistoryController : ControllerBase
    {
        [HttpGet("equipment-state-history")]
        public async Task<IActionResult> Get([FromServices] IEquipmentStateHistoryRepository repository) 
        {
            var equipmentStateHistories = await repository.GetAllAsync();

            if (equipmentStateHistories.Count() == 0)
                return Ok(new GenericCommandResult(true, "Você ainda não tem modelos de equipamento registrados", null));

            return Ok(new GenericCommandResult(true, "Seus modelos de equipamento", equipmentStateHistories));
        }
        [HttpGet("equipment-state-history/{equipmentId:Guid}")]
        public async Task<IActionResult> GetById([FromServices] IEquipmentStateHistoryRepository repository, 
            [FromRoute] Guid equipmentId) 
        {
            var equipmentStateHistory = await repository.GetByIdAsync(equipmentId);

            if (equipmentStateHistory == null)
                return NotFound(new GenericCommandResult(false, "Histórico de estado do equipamento não encontrado", null));

            return Ok(new GenericCommandResult(true, "Seu histórico de estado do equipamento", equipmentStateHistory));
        }

    }
}
