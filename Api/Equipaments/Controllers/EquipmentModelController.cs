using AutoMapper;
using Equipments.Data;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment;
using Equipments.Services;
using FluentResults;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Equipments.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class EquipmentModelController : ControllerBase
    {
        private EquipmentModelService _equipmentModelService;

        public EquipmentModelController(EquipmentModelService equipmentModelService)
        {
            _equipmentModelService = equipmentModelService;
        }

        /// <summary>
        /// Cria um modelo de equipamento
        /// </summary>
        /// <param name="equipmentModelDto"></param>
        /// <returns>Cria um modelo de equipamento</returns>
        [HttpPost]
        public IActionResult AddEquipmentModel([FromBody] CreateEquipmentModelDto equipmentModelDto)
        {
            ReadEquipmentModelDto readDto = _equipmentModelService.AddEquipmentModel(equipmentModelDto);
            return CreatedAtAction(nameof(GetEquipmentModelById), new { Id = readDto.id }, readDto);
        }

        /// <summary>
        /// Retorna o modelo de equipamento utilizando o nome como filtro. Obs: nome vazio = todos
        /// </summary>
        /// <param name="equipmentModelName"></param>
        /// <returns>Retorna o modelo de equipamento</returns>
        [HttpGet]
        public IActionResult GetEquipmentModel(string equipmentModelName)
        {
            List<ReadEquipmentModelDto> readDto = _equipmentModelService.GetEquipmentModel(equipmentModelName);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Retorna o modelo de equipamento pelo id
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Retorna o modelo de equipamento pelo id</returns>
        [HttpGet("{id}")]
        public IActionResult GetEquipmentModelById(Guid id)
        {
            ReadEquipmentModelDto readDto = _equipmentModelService.GetEquipmentModelById(id);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Realiza a atualização do modelo de equipamento pelo id
        /// </summary>
        /// <param name="id"></param>
        /// <param name="equipmentModelDto"></param>
        /// <returns>Realiza a atualização do modelo de equipamento pelo id</returns>
        [HttpPut("{id}")]
        public IActionResult UpdateEquipmentModel(Guid id, [FromBody] UpdateEquipmentModelDto equipmentModelDto)
        {
            Result result = _equipmentModelService.UpdateEquipmentModel(id, equipmentModelDto);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }

        /// <summary>
        /// Deleta o Modelo do Equipamento
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Deleta o Modelo do Equipamento</returns>
        [HttpDelete("{id}")]
        public IActionResult DeleteEquipmentModel(Guid id)
        {
            Result result = _equipmentModelService.DeleteEquipmentModel(id);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }
    }
}
