using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace Aiko_ProcessoSeletivo_WebApi.Controllers
{
    [Produces("application/json")]

    [Route("api/[controller]")]
    [ApiController]
    public class EquipmentModelsController : Controller
    {
        private readonly IEquipmentModelRepository _equipmentModelRepository;

        public EquipmentModelsController(IEquipmentModelRepository contexto)
        {
            _equipmentModelRepository = contexto;
        }

        [HttpGet]
        public IActionResult Listar()
        {
            try
            {
                return Ok(_equipmentModelRepository.Listar());

            }
            catch (Exception ex)
            {

                return StatusCode(500, ex);
            }
        }

        [HttpPost]
        public IActionResult CriarModeloEquipamento(EquipmentModel equipamento)
        {
            try
            {

                _equipmentModelRepository.Cadastrar(equipamento);
                return StatusCode(200, "Modelo de equipamento criado com sucesso");
            }
            catch (Exception ex)
            {

                return BadRequest(ex);
            }
        }

        [HttpPut("{Id}")]
        public IActionResult AtualizaEquipamento(EquipmentModel equipamento, Guid Id)
        {
            try
            {

                _equipmentModelRepository.Atualizar(Id, equipamento);
                return StatusCode(200, "Modelo de equipamento alterado com sucesso");

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

                _equipmentModelRepository.Deletar(Id);
                return StatusCode(200, "Modelo de equipamento apagado com sucesso");


            }
            catch (Exception ex)
            {
                return StatusCode(500, ex);
            }
        }
    }
}
