using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using TesteEstágioBackendV2.Controllers.Base;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Interfaces.Services;

namespace TesteEstágioBackendV2.Controllers
{
    [Route("[controller]")]
    public class EquipmentPositionHistoryController : BaseApiController
    {
        private readonly IEquipmentPositionHistoryService _equipmentPositionHistoryService;

        public EquipmentPositionHistoryController(
            IEquipmentPositionHistoryService equipmentPositionHistoryService)
        {
            _equipmentPositionHistoryService = equipmentPositionHistoryService;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            return Ok(await _equipmentPositionHistoryService.GetAllAsync());
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(Guid id)
        {
            return Ok(await _equipmentPositionHistoryService.GetByIdAsync(id));
        }

        [HttpPost]
        public async Task<IActionResult> RegisterAsync(EquipmentPositionHistoryDTO request)
        {
            return Ok(await _equipmentPositionHistoryService.RegisterAsync(request));
        }

        [HttpPut]
        public async Task<IActionResult> UpdateAsync(EquipmentPositionHistoryDTO request)
        {
            return Ok(await _equipmentPositionHistoryService.UpdateAsync(request));
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(Guid id)
        {
            return Ok(await _equipmentPositionHistoryService.RemoveAsync(id));
        }
    }
}