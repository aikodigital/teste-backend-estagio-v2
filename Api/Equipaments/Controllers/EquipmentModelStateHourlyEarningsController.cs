using Equipments.Data.Dtos.Equipment_Model_State_Hourly_earnings;
using Equipments.Services;
using FluentResults;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;

namespace Equipments.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class EquipmentModelStateHourlyEarningsController : ControllerBase
    {
        private EquipmentModelStateHourlyEarningsService _hourlyEarningsService;

        public EquipmentModelStateHourlyEarningsController(EquipmentModelStateHourlyEarningsService hourlyEarningsService) 
        {
            _hourlyEarningsService = hourlyEarningsService;
        }

        /// <summary>
        /// Cria o ganho por hora de um estado
        /// </summary>
        /// <param name="hourlyEarningsDto"></param>
        /// <returns>Cria o ganho por hora de um estado</returns>
        [HttpPost]
        public IActionResult AddHourlyEarnings([FromBody] CreateEquipmentModelStateHourlyEarningsDto hourlyEarningsDto)
        {
            ReadEquipmentModelStateHourlyEarningsDto readDto = _hourlyEarningsService.AddHourlyEarnings(hourlyEarningsDto);
            return CreatedAtAction(nameof(GetHourlyEarningsById), new { modelId = readDto.equipment_model_id, stateId = readDto.equipment_state_id }, readDto);
        }
        /// <summary>
        /// Retorna o ganho por hora de um estado
        /// </summary>
        /// <returns>Retorna o ganho por hora de um estado</returns>
        [HttpGet]
        public IActionResult GetHourlyEarnings()
        {
            List<ReadEquipmentModelStateHourlyEarningsDto> readDto = _hourlyEarningsService.GetHourlyEarnings();
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Retorna o ganho por hora de um estado pelo id do modelo e pelo id do estado
        /// </summary>
        /// <param name="modelId"></param>
        /// <param name="stateId"></param>
        /// <returns>Retorna o ganho por hora de um estado pelo id do modelo e pelo id do estado</returns>
        [HttpGet("{modelId}/{stateId}")]
        public IActionResult GetHourlyEarningsById(Guid modelId, Guid stateId)
        {
            ReadEquipmentModelStateHourlyEarningsDto readDto = _hourlyEarningsService.GetHourlyEarningsById(modelId, stateId);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Atualiza o ganho por hora de um estado pelo id do modelo e pelo id do estado
        /// </summary>
        /// <param name="modelId"></param>
        /// <param name="stateId"></param>
        /// <param name="hourlyEarningsDto"></param>
        /// <returns>Atualiza o ganho por hora de um estado pelo id do modelo e pelo id do estado</returns>
        [HttpPut("{modelId}/{stateId}")]
        public IActionResult UpdateHourlyEarnings(Guid modelId, Guid stateId, [FromBody] UpdateEquipmentModelStateHourlyEarningsDto hourlyEarningsDto)
        {
            Result result = _hourlyEarningsService.UpdateHourlyEarnings(modelId, stateId, hourlyEarningsDto);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }

        /// <summary>
        /// Delete o ganho por hora de um estado pelo id do modelo e pelo id do estado
        /// </summary>
        /// <param name="modelId"></param>
        /// <param name="stateId"></param>
        /// <returns>Delete o ganho por hora de um estado pelo id do modelo e pelo id do estado</returns>
        [HttpDelete("{modelId}/{stateId}")]
        public IActionResult DeleteHourlyEarnings(Guid modelId, Guid stateId)
        {
            Result result = _hourlyEarningsService.DeleteHourlyEarnings(modelId,stateId);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }
    }
}
