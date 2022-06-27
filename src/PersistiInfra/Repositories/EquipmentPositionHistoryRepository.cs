using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.domain;
using TesteEstágioBackendV2.src.PersistiInfra.Contexts;

namespace TesteEstágioBackendV2.src.PersistiInfra.Repositories
{
    public class EquipmentPositionHistoryRepository : 
        GenericRepositoryAsync<EquipmentPositionHistory>,
        IEquipmentPositionHistoryRepository
    {
        private readonly DbSet<EquipmentPositionHistory> equipment;

        public EquipmentPositionHistoryRepository(ApplicationDbContext dbContext) : base(dbContext)
        {
            equipment = dbContext.Set<EquipmentPositionHistory>();
        }

        public async Task<EquipmentPositionHistory> GetPosicaoAtualById(Guid id)
        {
            return await equipment
                .AsNoTracking()
                .Where(x => x.equipment == id)
                .OrderByDescending(x => x.date)
                .FirstAsync();
        }
    }
}