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
    public class EquipmentStateController : BaseApiController
    {
        private readonly IEquipmentStateService _equipmentStateService;

        public EquipmentStateController(IEquipmentStateService equipmentStateService)
        {
            _equipmentStateService = equipmentStateService;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            return Ok(await _equipmentStateService.GetAllAsync());
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id)
        {
            return Ok(await _equipmentStateService.GetByIdAsync(id));
        }

        [HttpPost]
        public async Task<IActionResult> RegisterAsync(EquipmentStateDTO request)
        {
            return Ok(await _equipmentStateService.RegisterAsync(request));
        }

        [HttpPut]
        public async Task<IActionResult> UpdateAsync(EquipmentStateDTO request)
        {
            return Ok(await _equipmentStateService.UpdateAsync(request));
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id)
        {
            return Ok(await _equipmentStateService.RemoveAsync(id));
        }
    }
}