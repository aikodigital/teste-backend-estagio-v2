using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;

namespace Aiko_ProcessoSeletivo_WebApi.Interfaces
{
    public interface IEquipmentPositionHistoryRepository
    {
        /// <summary>
        /// Lista todos os historicos de estados
        /// </summary>
        /// <returns>Uma lista de historico de estados</returns>
        List<EquipmentPositionHistory> Listar();

        /// <summary>
        /// Atualiza um historico de estado existente
        /// </summary>
        /// <param name="historicoEstadoAtualizado">Objeto com as novas informações</param>
        void Atualizar(EquipmentPositionHistoryViewModel historicoEstadoAtualizado);

        /// <summary>
        /// Deleta um historico de estado existente
        /// </summary>
        /// <param name="historicoEstado">OBJ que será deletado</param>
        void Deletar(EquipmentPositionHistoryViewModel historicoEstado);

        /// <summary>
        /// Cadastra um ganho
        /// </summary>
        /// <param name="historicoEstado">OBJ que será cadastrado</param>
        public void Cadastrar(EquipmentPositionHistoryViewModel historicoEstado);

        /// <summary>
        /// Lista o ultimo historico de localização de um equipamento
        /// </summary>
        /// <param name="history">OBJ com o id do equipamento que deseja consultar</param>
        /// <returns> A ultima localização de um equipamento</returns>
        public EquipmentPositionHistory RetornarUltimaLocalizacao(EquipmentPositionHistoryViewModel history);
    }
}
