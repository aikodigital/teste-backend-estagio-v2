using AikoCRUDAPI.Models;
using AikoCRUDAPI.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace AikoCRUDAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentStateController : ControllerBase
    {
        private readonly IEquipmentsStateRepos _equiprepos;

        public EquipmentStateController(IEquipmentsStateRepos equipmentsRepos)
        {
            _equiprepos = equipmentsRepos;
        }
        [HttpGet]
        public async Task<IEnumerable<EquipmentState>> Get()
        {
            return await _equiprepos.Get();
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<EquipmentState>> Get(Guid id)
        {
            return await _equiprepos.Get(id);
        }
        [HttpPost]
        public async Task<ActionResult<EquipmentState>> Post([FromBody]EquipmentState value)
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
        public async Task<ActionResult> Put(Guid id, [FromBody]EquipmentState value)
        {
            if (id == value.id)
            {
                await _equiprepos.Update(value);
            }
            return null;
        }
    }
}
