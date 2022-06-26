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
using TesteEstágioBackendV2.src.Apply.Interfaces;

namespace TesteEstágioBackendV2.Controllers
{
    [Route("[controller]")]
    public class EquipmentController : BaseApiController
    {
       private readonly IEquipmentService _equipmentService;

        public EquipmentController(IEquipmentService equipmentService)
        {
            _equipmentService = equipmentService;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            return Ok(await _equipmentService.GetAllAsync());
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(Guid id)
        {
            return Ok(await _equipmentService.GetByIdAsync(id));
        }

        [HttpPost]
        public async Task<IActionResult> RegisterAsync(EquipmentDTO request)
        {
            return Ok(await _equipmentService.RegisterAsync(request));
        }

        [HttpPut]
        public async Task<IActionResult> UpdateAsync(EquipmentDTO request)
        {
            return Ok(await _equipmentService.UpdateAsync(request));
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(Guid id)
        {
            return Ok(await _equipmentService.RemoveAsync(id));
        }

        [HttpGet("estado_atual/{id}")]
        public async Task<IActionResult> GetEstadoAtualById(Guid id)
        {
            return Ok(await _equipmentService.GetEstadoAtualById(id));
        }

        [HttpGet("posicao_atual/{id}")]
        public async Task<IActionResult> GetPosicaoAtualById(Guid id)
        {
            return Ok(await _equipmentService.GetPosicaoAtualById(id));
        }

        [HttpGet("ganhoPorEquipment/{id}")]
        public async Task<IActionResult> GetGanhoByEquipmentById(Guid id)
        {
            return Ok(await _equipmentService.GetGanhoByEquipamentoById(id));
        }

        [HttpGet("produtividadePorEquipment/{id}")]
        public async Task<IActionResult> GetProdutividadeByEquipmentById(Guid id)
        {
            return Ok(await _equipmentService.GetProdutividadeByEquipamentoById(id));
        }
    }
}