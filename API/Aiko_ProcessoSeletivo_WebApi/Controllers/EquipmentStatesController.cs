using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Aiko_ProcessoSeletivo_WebApi.Controllers
{
    [Produces("application/json")]

    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentStatesController : ControllerBase
    {
        private readonly IEquipmentStateRepository _equipmentStateRepository;

        public EquipmentStatesController(IEquipmentStateRepository contexto)
        {
            _equipmentStateRepository = contexto;
        }

        [HttpGet]
        public IActionResult Listar()
        {
            try
            {
                return Ok(_equipmentStateRepository.Listar());

            }
            catch (Exception ex)
            {

                return StatusCode(500, ex);
            }
        }

        [HttpPost]
        public IActionResult CriarEquipamento(EquipmentState equipamento)
        {
            try
            {

                _equipmentStateRepository.Cadastrar(equipamento);
                return StatusCode(200, "Estado criado com sucesso");
            }
            catch (Exception ex)
            {

                return BadRequest(ex);
            }
        }

        [HttpPut("{Id}")]
        public IActionResult AtualizaEquipamento(EquipmentState equipamento, Guid Id)
        {
            try
            {

                _equipmentStateRepository.Atualizar(Id, equipamento);
                return StatusCode(200, "Estado atualizado com sucesso");

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

                _equipmentStateRepository.Deletar(Id);
                return StatusCode(200, "Estado apagado com sucesso");


            }
            catch (Exception ex)
            {
                return StatusCode(500, ex);
            }
        }
    }
}
