using EquipmentApi.Data.Interfaces;
using EquipmentApi.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Repositories
{
    public class EquipmentPositionHistoryRepository : IEquipmentPositionHistoryRepository
    {
        private readonly EquipmentDbContext _context;

        public EquipmentPositionHistoryRepository(EquipmentDbContext context)
        {
            _context = context;
        }

        public async Task<EquipmentPositionHistory> AddAsync(EquipmentPositionHistory entity)
        {
            _context.EquipmentPositionHistories.Add(entity);
            await _context.SaveChangesAsync();
            return entity;
        }

        public async Task<bool> DeleteAllEquipmentPositionHistoryAsync(Guid equipmentId)
        {
            var result = _context.EquipmentPositionHistories.AsNoTracking().Where(e => e.EquipmentId.Equals(equipmentId));
            if (result == null) throw new InvalidOperationException("EquipmentId not found");
            foreach (var item in result)
            {
                _context.Remove(item);
            }
            return await _context.SaveChangesAsync() > 0;
        }

        public async Task<IEnumerable<EquipmentPositionHistory>> GetAllAsync()
        {
            IQueryable<EquipmentPositionHistory> query = _context.EquipmentPositionHistories;
            query = query.AsNoTracking().Include(e => e.Equipment).ThenInclude(em => em.EquipmentModel);
            return await query.ToListAsync();
        }

        public async Task<IEnumerable<EquipmentPositionHistory>> GetByIdAsync(Guid equipmentId)
        {
            IQueryable<EquipmentPositionHistory> query = _context.EquipmentPositionHistories.Where(e => e.EquipmentId.Equals(equipmentId));
            query = query.AsNoTracking().Include(e => e.Equipment).ThenInclude(em => em.EquipmentModel);
            return await query.ToListAsync();
        }

        public async Task<EquipmentPositionHistory> UpdateAsync(EquipmentPositionHistory entity)
        {
            var result = await _context.EquipmentPositionHistories.FirstOrDefaultAsync(e => e.EquipmentId.Equals(entity.EquipmentId));
            if (result == null) throw new InvalidOperationException("EquipmentId not found");
            _context.EquipmentPositionHistories.Update(entity);
            await _context.SaveChangesAsync();
            return result;
        }

        public async Task<IEnumerable<EquipmentPositionHistory>> GetMostRecentEquipmentPositionAsync()
        {
            IQueryable<EquipmentPositionHistory> query = _context.EquipmentPositionHistories.AsNoTracking().Include(e => e.Equipment).ThenInclude(em => em.EquipmentModel);
            var list = await query.ToListAsync();
            var result = list.ToList().GroupBy(e => e.EquipmentId).Select(eq => eq.OrderByDescending(o => o.Date).First());
            return result;
        }

        public async Task<EquipmentPositionHistory> GetMostRecentEquipmentPositionByEquipmentIdAsync(Guid equipmentId)
        {
            IQueryable<EquipmentPositionHistory> query = _context.EquipmentPositionHistories.AsNoTracking().Include(e => e.Equipment).ThenInclude(em => em.EquipmentModel);
            var result = await query.FirstOrDefaultAsync(o => o.EquipmentId.Equals(equipmentId));
            return result;

        }
    }
}
