using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using TesteEstágioBackendV2.Controllers;
using TesteEstágioBackendV2.Controllers.Base;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Interfaces.Services;

namespace TesteEstágioBackendV2.Controllers
{
    [Route("[controller]")]
    public class EquipmentModelStateHourlyEarningsController :  BaseApiController
    {
        private readonly IEquipmentModelStateHourlyEarningsService _equipmentModelStateHourlyEarningsService;

        public EquipmentModelStateHourlyEarningsController(IEquipmentModelStateHourlyEarningsService equipmentModelStateHourlyEarningsService)
        {
            _equipmentModelStateHourlyEarningsService = equipmentModelStateHourlyEarningsService;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            return Ok(await _equipmentModelStateHourlyEarningsService.GetAllAsync());
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(Guid id)
        {
            return Ok(await _equipmentModelStateHourlyEarningsService.GetByIdAsync(id));
        }

        [HttpPost]
        public async Task<IActionResult> RegisterAsync(EquipmentModelStateHourlyEarningsDTO request)
        {
            return Ok(await _equipmentModelStateHourlyEarningsService.RegisterAsync(request));
        }

        [HttpPut]
        public async Task<IActionResult> UpdateAsync(EquipmentModelStateHourlyEarningsDTO request)
        {
            return Ok(await _equipmentModelStateHourlyEarningsService.UpdateAsync(request));
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(Guid id)
        {
            return Ok(await _equipmentModelStateHourlyEarningsService.RemoveAsync(id));
        }
    }
}