using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.Enum;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.domain;

namespace TesteEstágioBackendV2.src.PersistiInfra.Repositories
{
    public class EquipmentStateHistoryRepository : 
        GenericRepositoryAsync<EquipmentStateHistory>,
        IEquipmentStateHistoryRepository
    {
        private readonly DbSet<EquipmentStateHistory> _dbContext;

        public EquipmentStateHistoryRepository(ApplicationDbContext dbContext) 
            : base(dbContext)
        {
            _dbContext = dbContext.Set<EquipmentStateHistory>();
        }

        public async Task<EquipmentStateHistory> GetEstadoAtualById(Guid id)
        {
            return await _dbContext
                .AsNoTracking()
                .Where(x => x.equipment_id == id)
                .OrderByDescending(x => x.date)
                .FirstAsync();
        }

        public async Task<int> GetQuantHorasOperando(Guid id)
        {
            return _dbContext
                .AsNoTracking()
                .Where(x => x.equipment_id == id && (Location)x.equipment_state_id == Location.OPERANDO)
                .OrderByDescending(x => x.date)
                .Count();
        }

        public async Task<int> GetQuantHorasManutencao(Guid id)
        {
            return _dbContext
                .AsNoTracking()
                .Where(x => x.equipment_id == id && (Location)x.equipment_state_id == Location.OPERANDO)
                .OrderByDescending(x => x.date)
                .Count();
        }

        public async Task<int> GetQuantHorasOperandoHoje(Guid id)
        {
            var hoje = DateTime.Now;

            return _dbContext
                .AsNoTracking()
                .Where(x => 
                (x.equipment_id == id)
                && ((Location)x.equipment_state_id == Location.OPERANDO)
                && (x.date.Year==hoje.Year && x.date.Month==hoje.Month && x.date.Day==hoje.Day)
                )
                .OrderByDescending(x => x.date)
                .Count();
        }

        public async Task<int> GetQuantHorasHoje(Guid id)
        {
            var hoje = DateTime.Now;

            return _dbContext
                .AsNoTracking()
                .Where(x => x.equipment_id == id
                && (x.date.Year == hoje.Year && x.date.Month == hoje.Month && x.date.Day == hoje.Day)
                )
                .OrderByDescending(x => x.date)
                .Count();
        }
    }
}