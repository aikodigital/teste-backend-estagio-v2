using AutoMapper;
using Equipments.Data;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment;
using Equipments.Services;
using Microsoft.AspNetCore.Mvc;
using FluentResults;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Equipments.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class EquipmentController : ControllerBase
    {
        private EquipmentService _equipmentService;

        public EquipmentController(EquipmentService equipmentService)
        {
            _equipmentService = equipmentService;
        }


        /// <summary>
        /// Cria um Equipamento
        /// </summary>
        /// <param name="equipmentDto"></param>
        /// <returns>Cria um Equipamento</returns>
        [HttpPost]
        public IActionResult AddEquipment([FromBody] CreateEquipmentDto equipmentDto)
        {
            ReadEquipmentDto readDto = _equipmentService.AddEquipment(equipmentDto);
            return CreatedAtAction(nameof(GetEquipmentById), new { Id = readDto.id }, readDto);
        }

        /// <summary>
        /// Retorna um Equipamento utilizando o nome como filtro. Obs: nome vazio = todos
        /// </summary>
        /// <param name="equipmentName"></param>
        /// <returns>Retorna um equipamento</returns>
        [HttpGet]
        public IActionResult GetEquipment(string equipmentName)
        {
            List<ReadEquipmentDto> readDto = _equipmentService.GetEquipment(equipmentName);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Retorna um Equipamento pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Retorna um Equipamento pelo ID</returns>
        [HttpGet("{id}")]
        public IActionResult GetEquipmentById(Guid id)
        {
            ReadEquipmentDto readDto = _equipmentService.GetEquipmentById(id);
            if (readDto == null) return NotFound();
            return Ok(readDto);
        }

        /// <summary>
        /// Atualiza um Equipamento pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <param name="equipmentDto"></param>
        /// <returns>Atualiza um Equipamento pelo ID</returns>
        [HttpPut("{id}")]
        public IActionResult UpdateEquipment(Guid id, [FromBody] UpdateEquipmentDto equipmentDto)
        {
            Result result = _equipmentService.UpdateEquipment(id, equipmentDto);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }

        /// <summary>
        /// Deleta o Equipamento pelo ID
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Deleta o Equipamento pelo ID</returns>
        [HttpDelete("{id}")]
        public IActionResult DeleteEquipment(Guid id)
        {
            Result result = _equipmentService.DeleteEquipment(id);
            if (result.IsFailed) return NotFound();
            return NoContent();
        }
    }
}
