using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.domain;

namespace TesteEstágioBackendV2.src.Apply.Interfaces.Repositories
{
    public interface IEquipmentModelStateHourlyEarningsRepository : IGenericRepositoryAsync<EquipmentModelStateHourlyEarnings>
    {
        Task<int> GetQuantHorasOperando(Guid id);

        Task<int> GetQuantHorasManutencao(Guid id);
    }
}