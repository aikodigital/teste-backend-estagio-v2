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
    public class EquipmentPositionHistoryController : ControllerBase
    {
        private readonly IEquipmentPositionHistoryRepository _repository;
        private readonly IMapper _mapper;

        public EquipmentPositionHistoryController(IEquipmentPositionHistoryRepository repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        [HttpGet("GetAll")]
        public async Task<IActionResult> GetAllAsync()
        {
            var result = _mapper.Map<IEnumerable<EquipmentPositionHistoryDto>>(await _repository.GetAllAsync());
            return Ok(result);
        }

        [HttpGet("GetById/{id}")]
        public async Task<IActionResult> GetByIdAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = _mapper.Map<IEnumerable<EquipmentPositionHistoryDto>>(await _repository.GetByIdAsync(id));
            return Ok(result);
        }

        [HttpGet("GetMostRecentEquipmentPosition")]
        public async Task<IActionResult> GetMostRecentEquipmentPositionAsync()
        {
            var result = _mapper.Map<IEnumerable<EquipmentPositionHistoryDto>>(await _repository.GetMostRecentEquipmentPositionAsync());
            return Ok(result);
        }

        [HttpGet("GetMostRecentEquipmentPositionByEquipmentId/{id}")]
        public async Task<IActionResult> GetMostRecentEquipmentPositionByEquipmentIdAsync(Guid equipmentId)
        {
            var result = _mapper.Map<EquipmentPositionHistoryDto>(await _repository.GetMostRecentEquipmentPositionByEquipmentIdAsync(equipmentId));
            return Ok(result);
        }

        [HttpGet("ShowMapWithLocalizationByEquipmentId/{equipmentId}")]
        public async Task<ContentResult> ShowMapWithLocalizationByEquipmentId(Guid equipmentId)
        {
            var result = await _repository.GetMostRecentEquipmentPositionByEquipmentIdAsync(equipmentId);
            return base.Content($"<iframe src='https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d30156.736834271138!2d{result.Lon}!3d{result.Lat}!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb4e5115a96ef082!2zMTnCsDA3JzM1LjUiUyA0NcKwNTYnNTEuOSJX!5e0!3m2!1spt-BR!2sbr!4v1656224171698!5m2!1spt-BR!2sbr' width='600' height='450' style='border:0;' allowfullscreen='' loading='lazy' referrerpolicy='no-referrer-when-downgrade'></iframe>", "text/html");
        }

        [HttpPost("Create")]
        public async Task<IActionResult> AddAsync(EquipmentPositionHistoryCreateDto entity)
        {
            var result = await _repository.AddAsync(_mapper.Map<EquipmentPositionHistory>(entity));
            if (result == null) return BadRequest();
            return Ok(result);
        }

        [HttpPatch("Update")]
        public async Task<IActionResult> UpdateAsync(EquipmentPositionHistoryCreateDto entity)
        {
            var result = await _repository.UpdateAsync(_mapper.Map<EquipmentPositionHistory>(entity));
            if (result == null) return BadRequest();
            return Ok(result);
        }

        [HttpDelete("DeleteAllEquipmentPositionHistory/{equipmentId}")]
        public async Task<IActionResult> DeleteAllEquipmentPositionHistoryAsync(Guid equipmentId)
        {
            if (equipmentId == Guid.Empty) return NotFound();
            var result = await _repository.DeleteAllEquipmentPositionHistoryAsync(equipmentId);
            if (!result) return BadRequest();
            return Ok(result);
        }
    }
}
