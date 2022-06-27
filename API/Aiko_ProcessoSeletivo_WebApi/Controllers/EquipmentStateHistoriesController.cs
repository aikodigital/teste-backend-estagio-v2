using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Aiko_ProcessoSeletivo_WebApi.Controllers
{
    [Produces("application/json")]

    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentStateHistoriesController : ControllerBase
    {
        private readonly IEquipmentStateHistoryRepository _stateHistoryRepository;

        public EquipmentStateHistoriesController(IEquipmentStateHistoryRepository contexto)
        {
            _stateHistoryRepository = contexto;
        }

        [HttpGet]
        public IActionResult Listar()
        {
            try
            {
                return Ok(_stateHistoryRepository.Listar());

            }
            catch (Exception ex)
            {

                return StatusCode(500, ex);
            }
        }

        [HttpPost]
        public IActionResult CadastrarHistoricoEstado(EquipmentStateHistoryViewModel history)
        {
            try
            {

                _stateHistoryRepository.Cadastrar(history);
                return StatusCode(200, "Historico de Estado cadastrados com sucesso");
            }
            catch (Exception ex)
            {

                return BadRequest(ex);
            }
        }

        [HttpPost("id")]
        public IActionResult ListaUltimoEstado(EquipmentStateHistoryViewModel history)
        {
            try
            {

                return StatusCode(200, _stateHistoryRepository.RetornarUltimoEstado(history));
            }
            catch (Exception ex)
            {

                return BadRequest(ex);
            }
        }

        [HttpPut]
        public IActionResult AtualizarHistoricoEstado(EquipmentStateHistoryViewModel history)
        {
            try
            {

                _stateHistoryRepository.Atualizar(history);
                return StatusCode(200, "Alterado com sucesso");

            }
            catch (Exception Erro)
            {
                return BadRequest(Erro);
            }
        }

        [HttpDelete]
        public IActionResult Delete(EquipmentStateHistoryViewModel history)
        {
            try
            {

                _stateHistoryRepository.Deletar(history);
                return StatusCode(200, "Historico de Estado apagado com sucesso");


            }
            catch (Exception ex)
            {
                return StatusCode(500, ex);
            }
        }
    }
}
