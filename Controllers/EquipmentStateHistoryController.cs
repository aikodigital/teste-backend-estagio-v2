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
    public class EquipmentStateHistoryController : BaseApiController
    {
        private readonly IEquipmentStateHistoryService _equipmentStateHistoryService;

        public EquipmentStateHistoryController(
            IEquipmentStateHistoryService equipmentStateHistoryService)
        {
            _equipmentStateHistoryService = equipmentStateHistoryService;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            return Ok(await _equipmentStateHistoryService.GetAllAsync());
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(Guid id)
        {
            return Ok(await _equipmentStateHistoryService.GetByIdAsync(id));
        }

        [HttpPost]
        public async Task<IActionResult> RegisterAsync(EquipmentStateHistoryDTO request)
        {
            return Ok(await _equipmentStateHistoryService.RegisterAsync(request));
        }

        [HttpPut]
        public async Task<IActionResult> UpdateAsync(EquipmentStateHistoryDTO request)
        {
            return Ok(await _equipmentStateHistoryService.UpdateAsync(request));
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(Guid id)
        {
            return Ok(await _equipmentStateHistoryService.RemoveAsync(id));
        }
    }
}