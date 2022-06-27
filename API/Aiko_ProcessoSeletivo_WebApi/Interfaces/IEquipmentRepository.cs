using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;

namespace Aiko_ProcessoSeletivo_WebApi.Interfaces
{
    public interface IEquipmentRepository
    {

        /// <summary>
        /// Lista todos os Equipamentos
        /// </summary>
        /// <returns>Uma lista de Equipamentos</returns>
        List<Equipment> Listar();

        /// <summary>
        /// Atualiza um Equipamento existente
        /// </summary>
        /// <param name="id">ID do Equipamento que será atualizado</param>
        /// <param name="equipamentoAtualizado">Objeto com as novas informações</param>
        void Atualizar(Guid id, EquipmentViewModel equipamentoAtualizado);

        /// <summary>
        /// Deleta um Equipamento existente
        /// </summary>
        /// <param name="id">ID do Equipamento que será deletado</param>
        void Deletar(Guid id);

        /// <summary>
        /// Busca um Equipamento através do ID
        /// </summary>
        /// <param name="id">ID do Equipamento que será buscado</param>
        /// <returns>Um Equipamento buscado</returns>
        Equipment BuscarPorId(Guid id);

        /// <summary>
        /// Cadastra um Equipamento
        /// </summary>
        /// <param name="equipamento">Equipamento que será cadastrado</param>
        public void Cadastrar(EquipmentViewModel equipamento);

    }
}
