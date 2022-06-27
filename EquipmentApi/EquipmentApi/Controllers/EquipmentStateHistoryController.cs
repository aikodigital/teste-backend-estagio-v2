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
    public class EquipmentStateHistoryController : ControllerBase
    {
        private readonly IEquipmentStateHistoryRepository _repository;
        private readonly IMapper _mapper;

        public EquipmentStateHistoryController(IEquipmentStateHistoryRepository repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        [HttpGet("GetAll")]
        public async Task<IActionResult> GetAllAsync()
        {
            var result = _mapper.Map<IEnumerable<EquipmentStateHistoryDto>>(await _repository.GetAllAsync());
            return Ok(result);
        }

        [HttpGet("GetByEquipmentId/{id}")]
        public async Task<IActionResult> GetByEquipmentIdAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = _mapper.Map<IEnumerable<EquipmentStateHistoryDto>>(await _repository.GetByEquipmentIdAsync(id));
            return Ok(result);
        }

        [HttpGet("GetByEquipmentStateId/{id}")]
        public async Task<IActionResult> GetByEquipmentStateIdAsync(Guid id)
        {
            if (id == Guid.Empty) return BadRequest();
            var result = _mapper.Map<IEnumerable<EquipmentStateHistoryDto>>(await _repository.GetByEquipmentStateIdAsync(id));
            return Ok(result);
        }

        [HttpGet("GetMostRecentEquipmentState/")]
        public async Task<IActionResult> GetMostRecentEquipmentStateAsync()
        {
            var result = _mapper.Map<IEnumerable<EquipmentStateHistoryDto>>(await _repository.GetMostRecentEquipmentStateAsync());
            return Ok(result);
        }

        [HttpGet("GetMostRecentEquipmentStateByEquipmentId/{id}")]
        public async Task<IActionResult> GetMostRecentEquipmentStateByEquipmentIdAsync(Guid equipmentId)
        {
            if (equipmentId == Guid.Empty) return NotFound();
            var result = _mapper.Map<EquipmentStateHistoryDto>(await _repository.GetMostRecentEquipmentStateByEquipmentIdAsync(equipmentId));
            return Ok(result);
        }

        [HttpPost("Create")]
        public async Task<IActionResult> AddAsync(EquipmentStateHistoryCreateDto entity)
        {
            var result = await _repository.AddAsync(_mapper.Map<EquipmentStateHistory>(entity));
            if (result == null) return BadRequest();
            return Ok(result);
        }

        [HttpPatch("Update")]
        public async Task<IActionResult> UpdateAsync(EquipmentStateHistoryCreateDto entity)
        {
            var result = await _repository.UpdateAsync(_mapper.Map<EquipmentStateHistory>(entity));
            if (result == null) return BadRequest();
            return Ok(result);
        }

        [HttpDelete("Delete")]
        public async Task<IActionResult> DeleteAsync(EquipmentStateHistoryDeleteDto equipment)
        {
            var result = await _repository.DeleteAsync(_mapper.Map<EquipmentStateHistory>(equipment));
            if (!result) return BadRequest();
            return Ok(result);
        }
    }
}
