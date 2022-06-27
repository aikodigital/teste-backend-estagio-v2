using AikoCRUDAPI.Models;
using Microsoft.EntityFrameworkCore;
using Npgsql;

namespace AikoCRUDAPI.Repositories
{
    public class EquipmentsStateHistoryRepos : IEquipmentsStateHistoryRepos
    {
        private readonly EquipmentContext _context;
        
        public EquipmentsStateHistoryRepos(EquipmentContext context)
        {
            _context = context;
        }
        public async Task<EquipmentStateHistory> Create(EquipmentStateHistory value)
        {
           _context.equipment_state_history.Add(value);
           await _context.SaveChangesAsync();
            return value;
        }
        public async Task Delete(Guid id)
        {
            var toDelete = _context.equipment_state_history.Find(id);            
            _context.equipment_state_history.Remove(toDelete);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentStateHistory>> Get()
        {
            return await _context.equipment_state_history.ToListAsync();
        }

        public async Task<EquipmentStateHistory> Get(Guid id)
        {
            return await _context.equipment_state_history.FindAsync(id);
        }

        public async Task Update(EquipmentStateHistory equipment)
        {
            _context.Entry(equipment).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
