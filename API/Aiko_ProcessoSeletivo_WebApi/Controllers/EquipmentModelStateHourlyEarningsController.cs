using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Aiko_ProcessoSeletivo_WebApi.Controllers
{
    [Produces("application/json")]

    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentModelStateHourlyEarningsController : ControllerBase
    {
        private readonly IEquipmentModelStateHourlyEarningRepository _earningsRepository;

        public EquipmentModelStateHourlyEarningsController(IEquipmentModelStateHourlyEarningRepository contexto)
        {
            _earningsRepository = contexto;
        }

        [HttpGet]
        public IActionResult Listar()
        {
            try
            {
                return Ok(_earningsRepository.Listar());

            }
            catch (Exception ex)
            {

                return StatusCode(500, ex);
            }
        }

        [HttpPost]
        public IActionResult CadastrarGanhos(EarningViewModel ganhos)
        {
            try
            {

                _earningsRepository.Cadastrar(ganhos);
                return StatusCode(200, "Ganhos cadastrados com sucesso");
            }
            catch (Exception ex)
            {

                return BadRequest(ex);
            }
        }

        [HttpPut]
        public IActionResult AtualizaGanhos(EarningViewModel ganhos)
        {
            try
            {

                _earningsRepository.Atualizar(ganhos);
                return StatusCode(200, "Alterado com sucesso");

            }
            catch (Exception Erro)
            {
                return BadRequest(Erro);
            }
        }

        [HttpDelete]
        public IActionResult Delete(EarningViewModel ganhos)
        {
            try
            {

                _earningsRepository.Deletar(ganhos);
                return StatusCode(200, "Ganhos apagado com sucesso");


            }
            catch (Exception ex)
            {
                return StatusCode(500, ex);
            }
        }
    }
}
