using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Aiko_ProcessoSeletivo_WebApi.Controllers
{
    [Produces("application/json")]

    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentPositionHistoriesController : ControllerBase
    {
        private readonly IEquipmentPositionHistoryRepository _positionHistoryRepository;

        public EquipmentPositionHistoriesController(IEquipmentPositionHistoryRepository contexto)
        {
            _positionHistoryRepository = contexto;
        }

        [HttpGet]
        public IActionResult Listar()
        {
            try
            {
                return Ok(_positionHistoryRepository.Listar());

            }
            catch (Exception ex)
            {

                return StatusCode(500, ex);
            }
        }

        [HttpPost]
        public IActionResult CadastrarHistoricoposicao(EquipmentPositionHistoryViewModel history)
        {
            try
            {

                _positionHistoryRepository.Cadastrar(history);
                return StatusCode(200, "Historico de Posição cadastrados com sucesso");
            }
            catch (Exception ex)
            {

                return BadRequest(ex);
            }
        }

        [HttpPost("id")]
        public IActionResult ListaUltimoEstado(EquipmentPositionHistoryViewModel history)
        {
            try
            {

                return StatusCode(200, _positionHistoryRepository.RetornarUltimaLocalizacao(history));
            }
            catch (Exception ex)
            {

                return BadRequest(ex);
            }
        }

        [HttpPut]
        public IActionResult AtualizarHistoricoPosicao(EquipmentPositionHistoryViewModel history)
        {
            try
            {

                _positionHistoryRepository.Atualizar(history);
                return StatusCode(200, "Alterado com sucesso");

            }
            catch (Exception Erro)
            {
                return BadRequest(Erro);
            }
        }

        [HttpDelete]
        public IActionResult Delete(EquipmentPositionHistoryViewModel history)
        {
            try
            {

                _positionHistoryRepository.Deletar(history);
                return StatusCode(200, "Historico de Posição apagado com sucesso");


            }
            catch (Exception ex)
            {
                return StatusCode(500, ex);
            }
        }
    }
}
