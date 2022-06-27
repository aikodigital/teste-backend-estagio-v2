using AikoCRUDAPI.Models;
using Microsoft.EntityFrameworkCore;
using Npgsql;

namespace AikoCRUDAPI.Repositories
{
    public class EquipmentsPositionHistoryRepos : IEquipmentsPositionHistoryRepos
    {
        private readonly EquipmentContext _context;
        
        public EquipmentsPositionHistoryRepos(EquipmentContext context)
        {
            _context = context;
        }
        public async Task<EquipmentPositionHistory> Create(EquipmentPositionHistory value)
        {
           _context.equipment_position_history.Add(value);
           await _context.SaveChangesAsync();
            return value;
        }
        public async Task Delete(Guid id)
        {
            var toDelete = _context.equipment_position_history.Find(id);            
            _context.equipment_position_history.Remove(toDelete);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentPositionHistory>> Get()
        {
            return await _context.equipment_position_history.ToListAsync();
        }

        public async Task<EquipmentPositionHistory> Get(Guid equipment_id)
        {
            return await _context.equipment_position_history.FindAsync(equipment_id);
        }

        public async Task Update(EquipmentPositionHistory equipment)
        {
            _context.Entry(equipment).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
