using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TesteEstágioBackendV2.src.Apply.Enum;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.domain;

namespace TesteEstágioBackendV2.src.PersistiInfra.Repositories
{
    public class EquipmentModelStateHourlyEarningsRepository : GenericRepositoryAsync<EquipmentModelStateHourlyEarnings>,
        IEquipmentModelStateHourlyEarningsRepository
    {
        private readonly DbSet<EquipmentModelStateHourlyEarnings> equipmentModelStateHourlyEarnings;

        public EquipmentModelStateHourlyEarningsRepository(ApplicationDbContext dbContext) : base(dbContext)
        {
            equipmentModelStateHourlyEarnings = dbContext.Set<EquipmentModelStateHourlyEarnings>();
        }

        public async Task<int> GetQuantHorasOperando(Guid id)
        {
            var dado = await equipmentModelStateHourlyEarnings
                .AsNoTracking()
                .Where(x => x.equipmentModel == id 
                && (Location)x.equipmentState == Location.OPERANDO)
                .FirstOrDefaultAsync();
            return dado != null ? (int)dado.value : 0;
        }

        public async Task<int> GetQuantHorasManutencao(Guid id)
        {
            var dado = await equipmentModelStateHourlyEarnings
                .AsNoTracking()
                .Where(x => x.equipmentModel == id
                && (Location)x.equipmentState == Location.MANUTENCAO)
                .FirstOrDefaultAsync();
            return dado != null ? (int)dado.value : 0;
        }
    }
}