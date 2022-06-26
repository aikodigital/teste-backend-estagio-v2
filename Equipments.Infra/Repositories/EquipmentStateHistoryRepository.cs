using Equipments.Domain.Entities;
using Equipments.Domain.Repositories;
using Equipments.Infra.Context;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Infra.Repositories
{
    public class EquipmentStateHistoryRepository : IEquipmentStateHistoryRepository
    {
        private readonly EquipmentsContext _context;

        public EquipmentStateHistoryRepository(EquipmentsContext context)
        {
            _context = context;
        }

        public async Task CreateAsync(EquipmentStateHistory equipmentStateHistory)
        {
            await _context.EquipmentStateHistory.AddAsync(equipmentStateHistory);
            await _context.SaveChangesAsync();
        }

        public async Task DeleteAsync(EquipmentStateHistory equipmentStateHistory)
        {
            _context.EquipmentStateHistory.Remove(equipmentStateHistory);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentStateHistory>> GetAllAsync()
        {
            return await _context.EquipmentStateHistory.AsNoTracking().ToListAsync();
        }

        public async Task<IEnumerable<EquipmentStateHistory>> GetByIdAsync(Guid equipmentId)
        {
            return await _context
                .EquipmentStateHistory
                .AsNoTracking()
                .Where(x => x.EquipmentId == equipmentId)
                .ToListAsync();
        }

        public async Task UpdateAsync(EquipmentStateHistory equipmentStateHistory)
        {
            _context.Entry(equipmentStateHistory).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
