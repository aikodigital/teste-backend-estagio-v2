using AikoCRUDAPI.Models;
using AikoCRUDAPI.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace AikoCRUDAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentModelController : ControllerBase
    {
        private readonly IEquipmentsModelRepos _equipmodelrepos;

        public EquipmentModelController(IEquipmentsModelRepos equipmentsRepos)
        {
            _equipmodelrepos = equipmentsRepos;
        }
        [HttpGet]
        public async Task<IEnumerable<EquipmentModel>> Get()
        {
            return await _equipmodelrepos.Get();
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<EquipmentModel>> Get(Guid id)
        {
            return await _equipmodelrepos.Get(id);
        }
        [HttpPost]
        public async Task<ActionResult<EquipmentModel>> Post([FromBody]EquipmentModel value)
        {

            var newEquip = await _equipmodelrepos.Create(value);

            return value;
        }
        [HttpDelete("{id}")]
        public async Task<ActionResult> Delete(Guid id)
        {
            var equipmentToDelete =  await _equipmodelrepos.Get(id);
            if(equipmentToDelete != null)
            {
                await _equipmodelrepos.Delete(equipmentToDelete.id);
            }
            return null;
        }
        [HttpPut]
        public async Task<ActionResult> Put(Guid id, [FromBody]EquipmentModel value)
        {
            if (id == value.id)
            {
                await _equipmodelrepos.Update(value);
            }
            return null;
        }
    }
}
