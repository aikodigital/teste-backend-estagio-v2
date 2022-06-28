using Domain.Dtos.Equipment;
using Domain.Interfaces.Services;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Threading.Tasks;

namespace application.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentPositionHistoryController : ControllerBase
    {
        private IEquipmentPositionHistoryService _service;

        public EquipmentPositionHistoryController(IEquipmentPositionHistoryService service)
        {
            _service = service;
        }
        
        [HttpGet]
        public async Task<ActionResult> GetAll()
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            try
            {
                return Ok(await _service.GetAll());
            }
            catch (ArgumentException e)
            {

                return StatusCode((int)HttpStatusCode.InternalServerError, e.Message);
            }
        }

        
        [HttpGet]
        [Route("{id}")]

        public async Task<ActionResult> Get(Guid id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            try
            {
                return Ok(await _service.Get(id));
            }
            catch (ArgumentException e)
            {
                return StatusCode((int)HttpStatusCode.InternalServerError, e.Message);
            }
        }

        
        [HttpPost]
        public async Task<ActionResult> Post([FromBody] EquipmentPositionHistoryDto EquipmentPositionHistory)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            try
            {
                var result = await _service.Post(EquipmentPositionHistory);
                if (result != null)
                {
                    return Ok(this.Get(result.Id));
                }
                else
                {
                    return BadRequest();
                }
            }
            catch (ArgumentException e)
            {
                return StatusCode((int)HttpStatusCode.InternalServerError, e.Message);
            }
        }

        
        [HttpPut]
        public async Task<ActionResult> Put([FromBody] EquipmentPositionHistoryDto EquipmentPositionHistory)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            try
            {
                var result = await _service.Put(EquipmentPositionHistory);
                if (result != null)
                {
                    return Ok(result);
                }
                else
                {
                    return BadRequest();
                }
            }
            catch (ArgumentException e)
            {
                return StatusCode((int)HttpStatusCode.InternalServerError, e.Message);
            }
        }

        
        [HttpDelete("{id}")]

        public async Task<ActionResult> Delete(Guid id)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            try
            {
                return Ok(await _service.Delete(id));
            }
            catch (ArgumentException e)
            {
                return StatusCode((int)HttpStatusCode.InternalServerError, e.Message);
            }
        }
        [HttpGet]
        [Route("GetActualPositionState/{idEquipment}")]
        public async Task<ActionResult> GetActualPositionEquipment(Guid idEquipment)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            try
            {
                return Ok(await _service.GetActualEquipment(idEquipment));
            }
            catch (ArgumentException e)
            {
                return StatusCode((int)HttpStatusCode.InternalServerError, e.Message);
            }
        }
    }
}

