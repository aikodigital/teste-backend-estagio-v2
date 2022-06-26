using Equipments.Domain.Entities;
using Equipments.Domain.Repositories;
using Equipments.Infra.Context;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Infra.Repositories
{
    public class EquipmentPositionHistoryRepository : IEquipmentPositionHistoryRepository
    {
        private readonly EquipmentsContext _context;

        public EquipmentPositionHistoryRepository(EquipmentsContext context)
        {
            _context = context;
        }

        public async Task CreateAsync(EquipmentPositionHistory equipmentPositionHistory)
        {
            await _context.EquipmentPositionHistory.AddAsync(equipmentPositionHistory);
            await _context.SaveChangesAsync();
        }

        public async Task DeleteAsync(EquipmentPositionHistory equipmentPositionHistory)
        {
            _context.EquipmentPositionHistory.Remove(equipmentPositionHistory);
            await _context.SaveChangesAsync();
        }

        public async Task<List<EquipmentPositionHistory>> GetAllAsync()
        {
            return await _context.EquipmentPositionHistory.AsNoTracking().ToListAsync();
        }

        public async Task<IEnumerable<EquipmentPositionHistory>> GetByIdAsync(Guid equipmentId)
        {
            return await _context.EquipmentPositionHistory.AsNoTracking().Where(x => x.EquipmentId == equipmentId).ToListAsync();
        }

        public async Task UpdateAsync(EquipmentPositionHistory equipmentPositionHistory)
        {
            _context.Entry(equipmentPositionHistory).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
