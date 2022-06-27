using AikoCRUDAPI.Models;
using AikoCRUDAPI.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace AikoCRUDAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentModelStateHourlyEarningsController : ControllerBase
    {
        private readonly IEquipmentsModelStateHourlyEarningsRepos _equiprepos;

        public EquipmentModelStateHourlyEarningsController(IEquipmentsModelStateHourlyEarningsRepos equipmentsRepos)
        {
            _equiprepos = equipmentsRepos;
        }
        [HttpGet]
        public async Task<IEnumerable<EquipmentModelStateHourlyEarnings>> Get()
        {
            return await _equiprepos.Get();
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<EquipmentModelStateHourlyEarnings>> Get(Guid id)
        {
            return await _equiprepos.Get(id);
        }
        [HttpPost]
        public async Task<ActionResult<EquipmentModelStateHourlyEarnings>> Post([FromBody] EquipmentModelStateHourlyEarnings value)
        {

            var newEquip = await _equiprepos.Create(value);

            return value;
        }
        [HttpDelete("{id}")]
        public async Task<ActionResult> Delete(Guid id)
        {
            var equipmentToDelete =  await _equiprepos.Get(id);
            if(equipmentToDelete != null)
            {
                await _equiprepos.Delete(equipmentToDelete.id);
            }
            return null;
        }
        [HttpPut]
        public async Task<ActionResult> Put(Guid id, [FromBody] EquipmenModelStateHourlyEarningst value)
        {
            if (id == value.id)
            {
                await _equiprepos.Update(value);
            }
            return null;
        }
    }
}
