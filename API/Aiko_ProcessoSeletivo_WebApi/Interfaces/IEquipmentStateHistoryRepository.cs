using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;

namespace Aiko_ProcessoSeletivo_WebApi.Interfaces
{
    public interface IEquipmentStateHistoryRepository
    {
         /// <summary>
        /// Lista todos os historicos de estados
        /// </summary>
        /// <returns>Uma lista de historico de estados</returns>
        List<EquipmentStateHistory> Listar();

        /// <summary>
        /// Atualiza um historico de estado existente
        /// </summary>
        /// <param name="historicoEstadoAtualizado">Objeto com as novas informações</param>
        void Atualizar(EquipmentStateHistoryViewModel historicoEstadoAtualizado);

        /// <summary>
        /// Deleta um historico de estado existente
        /// </summary>
        /// <param name="historicoEstado">OBJ que será deletado</param>
        void Deletar(EquipmentStateHistoryViewModel historicoEstado);

        /// <summary>
        /// Cadastra um ganho
        /// </summary>
        /// <param name="historicoEstado">OBJ que será cadastrado</param>
        public void Cadastrar(EquipmentStateHistoryViewModel historicoEstado);

        /// <summary>
        /// Lista o ultimo historico de estados de um equipamento
        /// </summary>
        /// <param name="history">OBJ com o id do equipamento que deseja consultar</param>
        /// <returns> O ultimo estado de um equipamento</returns>
        public EquipmentStateHistory RetornarUltimoEstado(EquipmentStateHistoryViewModel history);
    }
}
