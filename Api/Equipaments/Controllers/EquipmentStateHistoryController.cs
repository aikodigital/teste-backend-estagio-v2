using Equipments.Data.Dtos.Equipment_State_History;
using Equipments.Services;
using FluentResults;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;

namespace Equipments.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class EquipmentStateHistoryController : ControllerBase
    {
        private EquipmentStateHistoryService _stateService;

        public EquipmentStateHistoryController(EquipmentStateHistoryService stateService)
        {
            _stateService = stateService;
        }

        /// <summary>
        /// Adiciona um posição de um equipamento 
        /// </summary>
        /// <param name="stateHistoryDto"></param>
        /// <returns>Adiciona um posição de um equipamento </returns>
        [HttpPost]
        public IActionResult AddPosition([FromBody] CreateEquipmentStateHistoryDto stateHistoryDto)
        {
            ReadEquipmentStateHistoryDto readDto = _stateService.AddStateHistory(stateHistoryDto);
            return CreatedAtAction(nameof(GetPositionHistoryByEquipmentId), new { equipmentId = readDto.equipment_id }, readDto);
        }

        /// <summary>
        /// Retorna um posição de um equipamento pelo ID do equipamento
        /// </summary>
        /// <param name="equipmentId"></param>
        /// <returns>Retorna um posição de um equipamento pelo ID do equipamento</returns>
        [HttpGet("{equipmentId}")]
        public IActionResult GetPositionHistoryByEquipmentId(Guid equipmentId)
        {
            List<ReadListEquipmentStateHistoryDto> readDto = _stateService.GetStateHistoryById(equipmentId);
            Console.WriteLine(readDto);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Retorna a última posição de um equipamento pelo ID do equipamento
        /// </summary>
        /// <param name="equipmentId"></param>
        /// <returns>Retorna a última posição de um equipamento pelo ID do equipamento</returns>
        [HttpGet("LastState/{equipmentId}")]
        public IActionResult RecuperaLastState(Guid equipmentId)
        {
            ReadEquipmentStateHistoryDto stateHistoryDto = _stateService.GetLastStateHistory(equipmentId);
            return Ok(stateHistoryDto);
        }

        /// <summary>
        /// Atualiza a posição de um equipamento pelo ID do equipamento e pela Data cadastrada
        /// </summary>
        /// <param name="equipmentId"></param>
        /// <param name="date"></param>
        /// <param name="stateHistoryDto"></param>
        /// <returns>Atualiza a posição de um equipamento pelo ID do equipamento e pela Data cadastrada</returns>
        [HttpPut("{equipmentId}/{date}")]
        public IActionResult UpdatePosition(Guid equipmentId, DateTime date, [FromBody] UpdateEquipmentStateHistoryDto stateHistoryDto)
        {
            Result result = _stateService.UpdateStateHistory(equipmentId, date, stateHistoryDto);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }

        /// <summary>
        /// Remove a posição de um equipamento pelo ID do equipamento e pela Data cadastrada
        /// </summary>
        /// <param name="equipmentId"></param>
        /// <param name="date"></param>
        /// <returns>Remove a posição de um equipamento pelo ID do equipamento e pela Data cadastrada</returns>
        [HttpDelete("{equipmentId}/{date}")]
        public IActionResult DeleteEquipment(Guid equipmentId, DateTime date)
        {
            Result result = _stateService.DeleteStateHistory(equipmentId, date);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }

    }
}
