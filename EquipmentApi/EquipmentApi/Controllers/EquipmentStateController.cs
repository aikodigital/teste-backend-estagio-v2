using AutoMapper;
using EquipmentApi.Data.Interfaces;
using EquipmentApi.Entities;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Threading.Tasks;

namespace EquipmentApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentStateController : ControllerBase
    {
        private readonly IEquipmentStateRepository _repository;

        public EquipmentStateController(IEquipmentStateRepository repository)
        {
            _repository = repository;
        }

        [HttpGet("GetAll")]
        public async Task<IActionResult> GetAllAsync()
        {
            var result = await _repository.GetAllAsync();
            return Ok(result);
        }

        [HttpGet("GetById/{id}")]
        public async Task<IActionResult> GetByIdAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = await _repository.GetByIdAsync(id);
            return Ok(result);
        }

        [HttpPost("Create")]
        public async Task<IActionResult> CreateAsync(EquipmentState equipmentState)
        {
            if (equipmentState == null) return BadRequest();
            var result = await _repository.AddAsync(equipmentState);
            return Ok(result);
        }

        [HttpPatch("Update")]
        public async Task<IActionResult> UpdateAsync(EquipmentState equipmentState)
        {
            if (equipmentState == null) return BadRequest();
            var result = await _repository.UpdateAsync(equipmentState);
            return Ok(result);
        }

        [HttpDelete("Delete/{id}")]
        public async Task<IActionResult> DeleteAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = await _repository.DeleteAsync(id);
            return Ok(result);
        }
    }
}
