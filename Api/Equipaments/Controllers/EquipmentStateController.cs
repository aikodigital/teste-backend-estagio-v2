using Equipments.Data.Dtos.Equipment_State;
using Equipments.Services;
using FluentResults;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;

namespace Equipments.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class EquipmentStateController : ControllerBase
    {
        private EquipmentStateService _equipmentStateService;

        public EquipmentStateController(EquipmentStateService equipmentStateService)
        {
            _equipmentStateService = equipmentStateService;
        }

        /// <summary>
        /// Adiciona um estado de equipamento
        /// </summary>
        /// <param name="equipmentStateDto"></param>
        /// <returns>Adiciona um estado de equipamento</returns>
        [HttpPost]
        public IActionResult AddEquipment([FromBody] CreateEquipmentStateDto equipmentStateDto)
        {
            ReadEquipmentStateDto readDto = _equipmentStateService.AddEquipmentState(equipmentStateDto);
            return CreatedAtAction(nameof(GetEquipmentById), new { Id = readDto.id }, readDto);
        }

        /// <summary>
        /// Retorna um estado de equipamento
        /// </summary>
        /// <param name="equipmentName"></param>
        /// <returns>Retorna um estado de equipamento</returns>
        [HttpGet]
        public IActionResult GetEquipment(string equipmentName)
        {
            List<ReadEquipmentStateDto> readDto = _equipmentStateService.GetEquipmentState(equipmentName);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Retorna um estado de equipamento pelo id
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Retorna um estado de equipamento pelo id</returns>
        [HttpGet("{id}")]
        public IActionResult GetEquipmentById(Guid id)
        {
            ReadEquipmentStateDto readDto = _equipmentStateService.GetEquipmentStateById(id);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Atualiza um estado de equipamento pelo id
        /// </summary>
        /// <param name="id"></param>
        /// <param name="equipmentDto"></param>
        /// <returns>Atualiza um estado de equipamento pelo id</returns>
        [HttpPut("{id}")]
        public IActionResult UpdateEquipment(Guid id, [FromBody] UpdateEquipmentStateDto equipmentDto)
        {
            Result result = _equipmentStateService.UpdateEquipmentState(id, equipmentDto);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }
        /// <summary>
        ///  Remove um estado de equipamento pelo id
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Remove um estado de equipamento pelo id</returns>
        [HttpDelete("{id}")]
        public IActionResult DeleteEquipment(Guid id)
        {
            Result result = _equipmentStateService.DeleteEquipmentState(id);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }
    }
}
