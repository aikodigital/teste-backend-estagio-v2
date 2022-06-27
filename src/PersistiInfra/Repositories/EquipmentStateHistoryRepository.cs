using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TesteEstágioBackendV2.src.Apply.Enum;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.domain;
using TesteEstágioBackendV2.src.PersistiInfra.Contexts;

namespace TesteEstágioBackendV2.src.PersistiInfra.Repositories
{
    public class EquipmentStateHistoryRepository : 
        GenericRepositoryAsync<EquipmentStateHistory>,
        IEquipmentStateHistoryRepository
    {
        private new readonly DbSet<EquipmentStateHistory> _dbContext;

        public EquipmentStateHistoryRepository(ApplicationDbContext dbContext) 
            : base(dbContext)
        {
            _dbContext = dbContext.Set<EquipmentStateHistory>();
        }

        public async Task<EquipmentStateHistory> GetEstadoAtualById(Guid id)
        {
            return await _dbContext
                .AsNoTracking()
                .Where(x => x.equipment == id)
                .OrderByDescending(x => x.date)
                .FirstAsync();
        }

        public Task<int> GetQuantHorasOperando(Guid id)
        {
            return Task.FromResult(_dbContext
                .AsNoTracking()
                .Where(x => x.equipment == id && (Location)x.equipmentState == Location.OPERANDO)
                .OrderByDescending(x => x.date)
                .Count());
        }

        public Task<int> GetQuantHorasManutencao(Guid id)
        {
            return Task.FromResult(_dbContext
                .AsNoTracking()
                .Where(x => x.equipment == id && (Location)x.equipmentState == Location.OPERANDO)
                .OrderByDescending(x => x.date)
                .Count());
        }

        public Task<int> GetQuantHorasOperandoHoje(Guid id)
        {
            var hoje = DateTime.Now;

            return Task.FromResult(_dbContext
                .AsNoTracking()
                .Where(x => 
                (x.equipment == id)
                && ((Location)x.equipmentState == Location.OPERANDO)
                && (x.date.Year==hoje.Year && x.date.Month==hoje.Month && x.date.Day==hoje.Day)
                )
                .OrderByDescending(x => x.date)
                .Count());
        }

        public Task<int> GetQuantHorasHoje(Guid id)
        {
            var hoje = DateTime.Now;

            return Task.FromResult(_dbContext
                .AsNoTracking()
                .Where(x => x.equipment == id
                && (x.date.Year == hoje.Year && x.date.Month == hoje.Month && x.date.Day == hoje.Day)
                )
                .OrderByDescending(x => x.date)
                .Count());
        }
    }
}