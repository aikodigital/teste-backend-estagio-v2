using Aiko_ProcessoSeletivo_WebApi.Domains;
using Aiko_ProcessoSeletivo_WebApi.ViewModel;

namespace Aiko_ProcessoSeletivo_WebApi.Interfaces
{
    public interface IEquipmentModelStateHourlyEarningRepository
    {

        /// <summary>
        /// Lista todos os ganhos por hora
        /// </summary>
        /// <returns>Uma lista de ganhos</returns>
        List<EquipmentModelStateHourlyEarning> Listar();

        /// <summary>
        /// Atualiza um ganho existente
        /// </summary>
        /// <param name="id">ID do ganho que será atualizado</param>
        /// <param name="ganhosAtualizado">Objeto com as novas informações</param>
        void Atualizar(EarningViewModel ganhosAtualizado);

        /// <summary>
        /// Deleta um ganho existente
        /// </summary>
        /// <param name="id">ID do ganho que será deletado</param>
        void Deletar(EarningViewModel ganhos);

        /// <summary>
        /// Cadastra um ganho
        /// </summary>
        /// <param name="ganho">ganho que será cadastrado</param>
        public void Cadastrar(EarningViewModel ganho);

    }
}
