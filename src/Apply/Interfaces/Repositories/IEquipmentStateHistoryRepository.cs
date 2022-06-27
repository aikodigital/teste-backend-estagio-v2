using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.domain;

namespace TesteEstágioBackendV2.src.Apply.Interfaces.Repositories
{
    public interface IEquipmentStateHistoryRepository : IGenericRepositoryAsync<EquipmentStateHistory>
    {
        Task<EquipmentStateHistory> GetEstadoAtualById(Guid id);

        Task<int> GetQuantHorasOperando(Guid id);

        Task<int> GetQuantHorasManutencao(Guid id);

        Task<int> GetQuantHorasOperandoHoje(Guid id);

        Task<int> GetQuantHorasHoje(Guid id);
    }
}