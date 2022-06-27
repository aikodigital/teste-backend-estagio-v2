using AutoMapper;
using EquipmentApi.Data.Interfaces;
using EquipmentApi.Dtos.CreateDtos;
using EquipmentApi.Dtos.ReadDtos;
using EquipmentApi.Entities;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace EquipmentApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentController : ControllerBase
    {
        private readonly IEquipmentRepository _repository;
        private readonly IMapper _mapper;

        public EquipmentController(IEquipmentRepository repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        [HttpGet("GetAll")]
        public async Task<IActionResult> GetAllAsync()
        {
            var result = _mapper.Map<IEnumerable<EquipmentDto>>(await _repository.GetAllAsync());
            if (result == null) return BadRequest("");
            return Ok(result);
        }

        [HttpGet("GetById/{id}")]
        public async Task<IActionResult> GetByIdAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = _mapper.Map<EquipmentDto>(await _repository.GetByIdAsync(id));
            if (result == null) return BadRequest("");
            return Ok(result);
        }

        [HttpGet("GetEquipmentsByModelId/{modelId}")]
        public async Task<IActionResult> GetEquipmentsByModelIdAsync(Guid modelId)
        {
            if (modelId == Guid.Empty) return NotFound();
            var result = _mapper.Map<IEnumerable<EquipmentDto>>(await _repository.GetEquipmentsByModelId(modelId));
            if (result == null) return BadRequest("");
            return Ok(result);
        }

        [HttpPost("Create")]
        public async Task<IActionResult> CreateAsync(EquipmentCreateDto equipment)
        {
            if (equipment == null) return BadRequest("");
            var result = await _repository.AddAsync(_mapper.Map<Equipment>(equipment));
            if (result == null) BadRequest();
            return Ok(equipment);
        }

        [HttpPatch("Update")]
        public async Task<IActionResult> UpdateAsync(EquipmentCreateDto equipment)
        {
            if (equipment == null) return BadRequest("");
            var result = await _repository.UpdateAsync(_mapper.Map<Equipment>(equipment));
            if (result == null) BadRequest();
            return Ok(equipment);
        }

        [HttpDelete("Delete/{id}")]
        public async Task<IActionResult> DeleteAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = await _repository.DeleteAsync(id);
            if (result == false) return BadRequest();
            return Ok(result);
        }
    }
}
