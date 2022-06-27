using Aiko_ProcessoSeletivo_WebApi.Domains;

namespace Aiko_ProcessoSeletivo_WebApi.Interfaces
{
    public interface IEquipmentModelRepository
    {
        /// <summary>
        /// Lista todos os modelos de Equipamentos
        /// </summary>
        /// <returns>Uma lista de modelos de Equipamentos</returns>
        List<EquipmentModel> Listar();

        /// <summary>
        /// Atualiza um Equipamento existente
        /// </summary>
        /// <param name="id">ID do modelos de equipamento que será atualizado</param>
        /// <param name="equipamentoAtualizado">Objeto com as novas informações</param>
        void Atualizar(Guid id, EquipmentModel equipamentoAtualizado);

        /// <summary>
        /// Deleta um modelos de Equipamento existente
        /// </summary>
        /// <param name="id">ID do modelo do Equipamento que será deletado</param>
        void Deletar(Guid id);

        /// <summary>
        /// Busca um modelos de Equipamento através do ID
        /// </summary>
        /// <param name="id">ID do modelo do Equipamento que será buscado</param>
        /// <returns>Um modelos de Equipamento buscado</returns>
        EquipmentModel BuscarPorId(Guid id);

        /// <summary>
        /// Cadastra um modelos de Equipamento
        /// </summary>
        /// <param name="equipamento">modelos de Equipamento que será cadastrado</param>
        public void Cadastrar(EquipmentModel equipamento);
    }
}
