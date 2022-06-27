using EquipmentApi.Data.Interfaces;
using EquipmentApi.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Repositories
{
    public class EquipmentStateHistoryRepository : IEquipmentStateHistoryRepository
    {
        private readonly EquipmentDbContext _context;

        public EquipmentStateHistoryRepository(EquipmentDbContext context)
        {
            _context = context;
        }

        public async Task<EquipmentStateHistory> AddAsync(EquipmentStateHistory entity)
        {
            _context.EquipmentStateHistories.Add(entity);
            await _context.SaveChangesAsync();
            return entity;
        }

        public async Task<bool> DeleteAsync(EquipmentStateHistory equipment)
        {
            var result = await _context.EquipmentStateHistories
                               .FirstOrDefaultAsync(e => e.EquipmentId.Equals(equipment.EquipmentId) && e.EquipmentStateId.Equals(equipment.EquipmentStateId));
            _context.EquipmentStateHistories.Remove(result);
            return await _context.SaveChangesAsync() > 0;
        }

        public async Task<ICollection<EquipmentStateHistory>> GetAllAsync()
        {
            IQueryable<EquipmentStateHistory> query = _context.EquipmentStateHistories;
            query = query.Include(es => es.EquipmentState).AsNoTracking().Include(e => e.Equipment).ThenInclude(em => em.EquipmentModel);
            return await query.ToListAsync();
        }

        public async Task<IEnumerable<EquipmentStateHistory>> GetByEquipmentIdAsync(Guid id)
        {
            IQueryable<EquipmentStateHistory> query = _context.EquipmentStateHistories.Where(e => e.EquipmentId.Equals(id));
            query = query.Include(es => es.EquipmentState).AsNoTracking().Include(e => e.Equipment).ThenInclude(em => em.EquipmentModel);
            return await query.ToListAsync();
        }

        public async Task<IEnumerable<EquipmentStateHistory>> GetByEquipmentStateIdAsync(Guid id)
        {
            IQueryable<EquipmentStateHistory> query = _context.EquipmentStateHistories.Where(e => e.EquipmentStateId.Equals(id));
            query = query.Include(es => es.EquipmentState).AsNoTracking().Include(e => e.Equipment).ThenInclude(em => em.EquipmentModel);
            return await query.ToListAsync();
        }

        public async Task<EquipmentStateHistory> UpdateAsync(EquipmentStateHistory entity)
        {
            var result = await _context.EquipmentStateHistories
                               .FirstOrDefaultAsync(e => e.EquipmentId.Equals(entity.EquipmentId) && e.EquipmentStateId.Equals(entity.EquipmentStateId));
            
            if (result != null)
            {
                _context.EquipmentStateHistories.Update(entity);
            }
            else
            {
                throw new InvalidOperationException("EquipmentId or EquipmentStateId not found");
            }
            
            await _context.SaveChangesAsync();
            return result;
        }

        public async Task<IEnumerable<EquipmentStateHistory>> GetMostRecentEquipmentStateAsync()
        {
            IQueryable<EquipmentStateHistory> query = _context.EquipmentStateHistories;
            query = query.AsNoTracking().OrderByDescending(e => e.Date).Include(es => es.EquipmentState).Include(eq => eq.Equipment).ThenInclude(em => em.EquipmentModel);
            IEnumerable<EquipmentStateHistory> list = await query.ToListAsync();
            var result = list.ToList().GroupBy(x => x.EquipmentId, (key, g) => g.OrderByDescending(e => e.Date).First());
            return result;
        }

        public async Task<EquipmentStateHistory> GetMostRecentEquipmentStateByEquipmentIdAsync(Guid equipmentId)
        {
            IQueryable<EquipmentStateHistory> query = _context.EquipmentStateHistories.AsNoTracking().OrderByDescending(e => e.Date).Include(es => es.EquipmentState).Include(eq => eq.Equipment).ThenInclude(em => em.EquipmentModel);
            return await query.FirstOrDefaultAsync(a => a.EquipmentId.Equals(equipmentId));
        }
    }
}
