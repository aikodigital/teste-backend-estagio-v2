using Equipments.Domain.Commands;
using Equipments.Domain.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace Equipments.Api.Controllers
{
    [ApiController]
    public class EquipmentHourlyEarningsController : ControllerBase
    {
        [HttpGet("equipment-hourly-earnings")]
        public async Task<IActionResult> Get([FromServices] IEquipmentHourlyEarningsRepository repository) 
        {
            var equipmentHourlyEarnings = await repository.GetAllAsync();

            return Ok(new GenericCommandResult(true, "Seus ganhos", equipmentHourlyEarnings));
        }
        [HttpGet("equipment-hourly-earnings/{equipmentModelId:Guid}")]
        public async Task<IActionResult> GetById([FromServices] IEquipmentHourlyEarningsRepository repository, [FromRoute] Guid id) 
        {
            var equipmenthourlyEarnings = await repository.GetByIdAsync(id);

            return Ok(new GenericCommandResult(true, "Seus ganhos", equipmenthourlyEarnings));
        }
    }
}
