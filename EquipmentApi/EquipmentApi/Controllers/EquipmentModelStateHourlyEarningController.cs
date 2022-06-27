using AutoMapper;
using EquipmentApi.Data.Interfaces;
using EquipmentApi.Dtos.CreateDtos;
using EquipmentApi.Dtos.DeleteDtos;
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
    public class EquipmentModelStateHourlyEarningController : ControllerBase
    {
        private readonly IEquipmentModelStateHourlyEarningRepository _repository;
        private readonly IMapper _mapper;

        public EquipmentModelStateHourlyEarningController(IEquipmentModelStateHourlyEarningRepository repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        [HttpGet("GetAll")]
        public async Task<IActionResult> GetAllAsync()
        {
            var result = _mapper.Map<IEnumerable<EquipmentModelStateHourlyEarningDto>>(await _repository.GetAllAsync());
            return Ok(result);
        }

        [HttpGet("GetByModelId/{modelId}")]
        public async Task<IActionResult> GetByModelIdAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = _mapper.Map<IEnumerable<EquipmentModelStateHourlyEarningDto>>(await _repository.GetByModelIdAsync(id));
            return Ok(result);
        }

        [HttpGet("GetByStateId{stateId}")]
        public async Task<IActionResult> GetByStateIdAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = _mapper.Map<IEnumerable<EquipmentModelStateHourlyEarningDto>>(await _repository.GetByStateIdAsync(id));
            return Ok(result);
        }

        [HttpPost("Create")]
        public async Task<IActionResult> AddAsync(EquipmentModelStateHourlyEarningCreateDto entity)
        {
            var result = await _repository.AddAsync(_mapper.Map<EquipmentModelStateHourlyEarning>(entity));
            if (result == null) return BadRequest();
            return Ok(result);
        }

        [HttpPatch("Patch")]
        public async Task<IActionResult> UpdateAsync(EquipmentModelStateHourlyEarningCreateDto entity)
        {
            var result = await _repository.UpdateAsync(_mapper.Map<EquipmentModelStateHourlyEarning>(entity));
            if (result == null) return BadRequest();
            return Ok(result);
        }

        [HttpDelete("Delete")]
        public async Task<IActionResult> DeleteAsync(EquipmentModelStateHourlyEarningDeleteDto entity)
        {
            var result = await _repository.DeleteAsync(_mapper.Map<EquipmentModelStateHourlyEarning>(entity));
            if (!result) return BadRequest();
            return Ok(result);
        }
    }
}
