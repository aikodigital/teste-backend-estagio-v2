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
    public class EquipmentModelController : ControllerBase
    {
        private readonly IEquipmentModelRepository _repository;
        private readonly IMapper _mapper;

        public EquipmentModelController(IEquipmentModelRepository repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }

        [HttpGet("GetAll")]
        public async Task<IActionResult> GetAllAsync()
        {
            var result = _mapper.Map<IEnumerable<EquipmentModelShowDto>>(await _repository.GetAllAsync());
            return Ok(result);
        }

        [HttpGet("GetById/{id}")]
        public async Task<IActionResult> GetByIdAsync(Guid id)
        {
            if (id == Guid.Empty) return NotFound();
            var result = _mapper.Map<EquipmentModelShowDto>(await _repository.GetByIdAsync(id));
            return Ok(result);
        }

        [HttpPost("Create")]
        public async Task<IActionResult> CreateAsync(EquipmentModelCreateDto equipmentModel)
        {
            if (equipmentModel == null) return NotFound();
            var result = await _repository.AddAsync(_mapper.Map<EquipmentModel>(equipmentModel));
            if (result == null) BadRequest();
            return Ok(equipmentModel);
        }

        [HttpPatch("Update")]
        public async Task<IActionResult> UpdateAsync(EquipmentModelCreateDto equipmentModel)
        {
            if (equipmentModel == null) return NotFound();
            var result = await _repository.UpdateAsync(_mapper.Map<EquipmentModel>(equipmentModel));
            if (result == null) BadRequest();
            return Ok(equipmentModel);
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
