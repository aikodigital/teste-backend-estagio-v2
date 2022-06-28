using Equipments.Data.Dtos.Equipment_Position_History;
using Equipments.Services;
using FluentResults;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;

namespace Equipments.Controllers
{

    [ApiController]
    [Route("[controller]")]
    public class EquipmentPositionHistoryController : ControllerBase
    {
        private EquipmentPositionHistoryService _positionService;

        public EquipmentPositionHistoryController(EquipmentPositionHistoryService positionService)
        {
            _positionService = positionService;
        }

        /// <summary>
        /// Adiciona a posição de um equipamento
        /// </summary>
        /// <param name="positionDto"></param>
        /// <returns>Adiciona a posição de um equipamento</returns>
        [HttpPost]
        public IActionResult AddPosition([FromBody] CreateEquipmentPositionHistoryDto positionDto)
        {
            ReadEquipmentPositionHistoryDto readDto = _positionService.AddPosition(positionDto);
            return CreatedAtAction(nameof(GetPositionHistoryByEquipmentId), new { equipmentId = readDto.equipment_id }, readDto);
        }

        /// <summary>
        /// Retorna a posição de um equipamento pelo ID
        /// </summary>
        /// <param name="equipmentId"></param>
        /// <returns>Retorna a posição de um equipamento pelo ID</returns>
        [HttpGet("{equipmentId}")]
        public IActionResult GetPositionHistoryByEquipmentId(Guid equipmentId)
        {
            List<ReadEquipmentPositionHistoryDto> readDto = _positionService.GetPositionHistoryByEquipmentId(equipmentId);
            Console.WriteLine(readDto);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Retorna a ultima posição de um equipamento pelo ID do equipamento
        /// </summary>
        /// <param name="equipmentId"></param>
        /// <returns>Retorna a ultima posição de um equipamento pelo ID do equipamento</returns>
        [HttpGet("LastPosition/{equipmentId}")]
        public IActionResult RecuperaLastEquipment(Guid equipmentId)
        {
            ReadEquipmentPositionHistoryDto equipmentDto = _positionService.GetLastPosition(equipmentId);
            return Ok(equipmentDto);
        }

        /// <summary>
        /// Atualiza a posição de um equipamento pelo ID
        /// </summary>
        /// <param name="equipmentId"></param>
        /// <param name="date"></param>
        /// <param name="positionHistoryDto"></param>
        /// <returns>Atualiza a posição de um equipamento pelo ID</returns>
        [HttpPut("{equipmentId}/{date}")]
        public IActionResult UpdatePosition(Guid equipmentId, DateTime date, [FromBody] UpdateEquipmentPositionHistoryDto positionHistoryDto)
        {
            Result result = _positionService.UpdatePosition(equipmentId, date, positionHistoryDto);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }

        /// <summary>
        /// Deleta a posição de um equipamento pelo ID
        /// </summary>
        /// <param name="equipmentId"></param>
        /// <param name="date"></param>
        /// <returns>Deleta a posição de um equipamento pelo ID</returns>
        [HttpDelete("{equipmentId}/{date}")]
        public IActionResult DeleteEquipment(Guid equipmentId, DateTime date)
        {
            Result result = _positionService.DeletePosition(equipmentId, date);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }

    }
}
