using EquipmentApi.Data.Interfaces;
using EquipmentApi.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Repositories
{
    public class EquipmentModelStateHourlyEarningRepository : IEquipmentModelStateHourlyEarningRepository
    {
        private readonly EquipmentDbContext _context;

        public EquipmentModelStateHourlyEarningRepository(EquipmentDbContext context)
        {
            _context = context;
        }

        public async Task<EquipmentModelStateHourlyEarning> AddAsync(EquipmentModelStateHourlyEarning entity)
        {
            _context.EquipmentModelStateHourlyEarnings.Add(entity);
            await _context.SaveChangesAsync();
            return entity;
        }

        public async Task<bool> DeleteAsync(EquipmentModelStateHourlyEarning entity)
        {
            IQueryable<EquipmentModelStateHourlyEarning> result = _context.EquipmentModelStateHourlyEarnings.Where(
                            e => e.EquipmentModelId.Equals(entity.EquipmentModelId) && e.EquipmentStateId.Equals(entity.EquipmentStateId)
                        );
            if (result == null) throw new InvalidOperationException("EquipmentModelId or EquipmentStateId not found");
            _context.Remove(entity);
            return await _context.SaveChangesAsync() > 0;
        }

        public async Task<IEnumerable<EquipmentModelStateHourlyEarning>> GetAllAsync()
        {
            IQueryable<EquipmentModelStateHourlyEarning> query = _context.EquipmentModelStateHourlyEarnings;
            query = query.AsNoTracking().Include(em => em.EquipmentModel).Include(es => es.EquipmentState);
            return await query.ToListAsync();
        }

        public async Task<IEnumerable<EquipmentModelStateHourlyEarning>> GetByModelIdAsync(Guid id)
        {
            IQueryable<EquipmentModelStateHourlyEarning> query = _context.EquipmentModelStateHourlyEarnings.Where(e => e.EquipmentModelId.Equals(id));
            query = query.AsNoTracking().Include(em => em.EquipmentModel).Include(es => es.EquipmentState);
            return await query.ToListAsync();
        }

        public async Task<IEnumerable<EquipmentModelStateHourlyEarning>> GetByStateIdAsync(Guid id)
        {
            IQueryable<EquipmentModelStateHourlyEarning> query = _context.EquipmentModelStateHourlyEarnings.Where(e => e.EquipmentStateId.Equals(id));
            query = query.AsNoTracking().Include(em => em.EquipmentModel).Include(es => es.EquipmentState);
            return await query.ToListAsync();
        }

        public async Task<EquipmentModelStateHourlyEarning> UpdateAsync(EquipmentModelStateHourlyEarning entity)
        {
            var result = await _context.EquipmentModelStateHourlyEarnings.FirstOrDefaultAsync(
                            e => e.EquipmentModelId.Equals(entity.EquipmentModelId) && e.EquipmentStateId.Equals(entity.EquipmentStateId)
                        );
            if (result == null) throw new InvalidOperationException("EquipmentModelId or EquipmentStateId not found");
            _context.EquipmentModelStateHourlyEarnings.Update(entity);
            await _context.SaveChangesAsync();
            return result;
        }
    }
}
