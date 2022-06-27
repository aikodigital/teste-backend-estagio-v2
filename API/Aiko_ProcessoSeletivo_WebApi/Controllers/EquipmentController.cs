using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;

namespace Aiko_ProcessoSeletivo_WebApi.Controllers
{
    [Produces("application/json")]

    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentController : Controller
    {
        private readonly IEquipmentRepository _equipmentRepository;

        public EquipmentController(IEquipmentRepository contexto)
        {
            _equipmentRepository = contexto;
        }

        [HttpGet]
        public IActionResult Listar()
        {
            try
            {
                return Ok(_equipmentRepository.Listar());

            }
            catch (Exception ex)
            {

                return StatusCode(500, ex);
            }
        }

        [HttpPost]
        public IActionResult CriarEquipamento(EquipmentViewModel equipamento)
        {
            try
            {

                _equipmentRepository.Cadastrar(equipamento);
                return StatusCode(200, "Equipamento criado com sucesso");
            }
            catch (Exception ex)
            {

                return BadRequest(ex);
            }
        }

        [HttpPut("{Id}")]
        public IActionResult AtualizaEquipamento(EquipmentViewModel equipamento, Guid Id)
        {
            try
            {

                _equipmentRepository.Atualizar(Id, equipamento);
                return StatusCode(200, "Alterado com sucesso");

            }
            catch (Exception Erro)
            {
                return BadRequest(Erro);
            }
        }

        [HttpDelete("{Id}")]
        public IActionResult Delete(Guid Id)
        {
            try
            {

                _equipmentRepository.Deletar(Id);
                return StatusCode(200, "Equipamento apagado com sucesso");


            }
            catch (Exception ex)
            {
                return StatusCode(500, ex);
            }
        }
    }
}
