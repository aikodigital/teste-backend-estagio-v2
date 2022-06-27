using Aiko_ProcessoSeletivo_WebApi.Domains;

namespace Aiko_ProcessoSeletivo_WebApi.Interfaces
{
    public interface IEquipmentStateRepository
    {
        /// <summary>
        /// Lista todos os estados de Equipamentos
        /// </summary>
        /// <returns>Uma lista de estados de Equipamentos</returns>
        List<EquipmentState> Listar();

        /// <summary>
        /// Atualiza um estado
        /// </summary>
        /// <param name="id">ID do estado que será atualizado</param>
        /// <param name="estadoAtualizado">Objeto com as novas informações</param>
        void Atualizar(Guid id, EquipmentState estadoAtualizado);

        /// <summary>
        /// Deleta um estado existente
        /// </summary>
        /// <param name="id">ID do estado que será deletado</param>
        void Deletar(Guid id);

        /// <summary>
        /// Busca um estado através do ID
        /// </summary>
        /// <param name="id">ID do estado que será buscado</param>
        /// <returns>Um estado buscado</returns>
        EquipmentState BuscarPorId(Guid id);

        /// <summary>
        /// Cadastra um Equipamento
        /// </summary>
        /// <param name="estado">Equipamento que será cadastrado</param>
        public void Cadastrar(EquipmentState estado);
    }
}
