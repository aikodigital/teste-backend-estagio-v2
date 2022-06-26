using Equipments.Domain.Entities;
using Equipments.Domain.Repositories;
using Equipments.Infra.Context;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Infra.Repositories
{
    public class EquipmentStateRepository : IEquipmentStateRepository
    {
        private readonly EquipmentsContext _context;

        public EquipmentStateRepository(EquipmentsContext context)
        {
            _context = context;
        }

        public async Task CreateAsync(EquipmentState equipmentState)
        {
            await _context.EquipmentState.AddAsync(equipmentState);
            await _context.SaveChangesAsync();
        }

        public async Task DeleteAsync(EquipmentState equipmentState)
        {
            _context.EquipmentState.Remove(equipmentState);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentState>> GetAllAsync()
        {
            return await _context.EquipmentState.AsNoTracking().ToListAsync();
        }

        public async Task<EquipmentState> GetByIdAsync(Guid id)
        {
           return await _context.EquipmentState.AsNoTracking().Where(x => x.Id == id).FirstOrDefaultAsync();
        }

        public async Task UpdateAsync(EquipmentState equipmentState)
        {
            _context.Entry(equipmentState).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
