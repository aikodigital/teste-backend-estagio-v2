using Equipments.Domain.Entities;
using Equipments.Domain.Repositories;
using Equipments.Infra.Context;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Infra.Repositories
{
    public class EquipmentHourlyEarningsRepository : IEquipmentHourlyEarningsRepository
    {
        private readonly EquipmentsContext _context;

        public EquipmentHourlyEarningsRepository(EquipmentsContext context)
        {
            _context = context;
        }

        public async Task CreateAsync(EquipmentHourlyEarnings equipmentHourlyEarnings)
        {
            await _context.EquipmentHourlyEarnings.AddAsync(equipmentHourlyEarnings);
            await _context.SaveChangesAsync();
        }

        public async Task DeleteAsync(EquipmentHourlyEarnings equipmentHourlyEarnings)
        {
            _context.EquipmentHourlyEarnings.Remove(equipmentHourlyEarnings);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentHourlyEarnings>> GetAllAsync()
        {
            return await _context.EquipmentHourlyEarnings.AsNoTracking().ToListAsync();
        }

        public async Task<IEnumerable<EquipmentHourlyEarnings>> GetByIdAsync(Guid equipmentModelId)
        {
            return await _context
                .EquipmentHourlyEarnings
                .AsNoTracking()
                .Where(x => x.EquipmentModelId == equipmentModelId)
                .ToListAsync();
        }

        public async Task UpdateAsync(EquipmentHourlyEarnings equipmentHourlyEarnings)
        {
            _context.Entry(equipmentHourlyEarnings).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
