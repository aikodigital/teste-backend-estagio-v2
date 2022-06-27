using AikoCRUDAPI.Models;
using AikoCRUDAPI.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace AikoCRUDAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentPositionHistoryController : ControllerBase
    {
        private readonly IEquipmentsPositionHistoryRepos _equiprepos;

        public EquipmentPositionHistoryController(IEquipmentsPositionHistoryRepos equipmentsRepos)
        {
            _equiprepos = equipmentsRepos;
        }
        [HttpGet]
        public async Task<IEnumerable<EquipmentPositionHistory>> Get()
        {
            return await _equiprepos.Get();
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<EquipmentPositionHistory>> Get(Guid id)
        {
            return await _equiprepos.Get(id);
        }
        [HttpPost]
        public async Task<ActionResult<EquipmentPositionHistory>> Post([FromBody] EquipmentPositionHistory value)
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
                await _equiprepos.Delete(equipmentToDelete.equipment_id);
            }
            return null;
        }
        [HttpPut]
        public async Task<ActionResult> Put(Guid id, [FromBody] EquipmentPositionHistory value)
        {
            if (id == value.equipment_id)
            {
                await _equiprepos.Update(value);
            }
            return null;
        }
    }
}
