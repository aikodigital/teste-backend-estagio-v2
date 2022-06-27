using AikoCRUDAPI.Models;
using AikoCRUDAPI.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace AikoCRUDAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentStateHsitoryController : ControllerBase
    {
        private readonly IEquipmentsStateHistoryRepos _equiprepos;

        public EquipmentStateHsitoryController(IEquipmentsStateHistoryRepos equipmentsRepos)
        {
            _equiprepos = equipmentsRepos;
        }
        [HttpGet]
        public async Task<IEnumerable<EquipmentStateHistory>> Get()
        {
            return await _equiprepos.Get();
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<EquipmentStateHistory>> Get(Guid id)
        {
            return await _equiprepos.Get(id);
        }
        [HttpPost]
        public async Task<ActionResult<EquipmentStateHistory>> Post([FromBody] EquipmentStateHistory value)
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
        public async Task<ActionResult> Put(Guid eqid,Guid stid, [FromBody] EquipmentStateHistory value)
        {
            if (eqid == value.equipment_id && stid == value.equipment_state_id)
            {
                await _equiprepos.Update(value);
            }
            return null;
        }
    }
}
