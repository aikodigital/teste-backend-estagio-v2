using AikoCRUDAPI.Models;
using Microsoft.EntityFrameworkCore;
using Npgsql;

namespace AikoCRUDAPI.Repositories
{
    public class EquipmentsStateRepos : IEquipmentsStateRepos
    {
        private readonly EquipmentContext _context;
        
        public EquipmentsStateRepos(EquipmentContext context)
        {
            _context = context;
        }
        public async Task<EquipmentState> Create(EquipmentState value)
        {
           _context.equipment_state.Add(value);
           await _context.SaveChangesAsync();
            return value;
        }
        public async Task Delete(Guid id)
        {
            var toDelete = _context.equipment_state.Find(id);            
            _context.equipment_state.Remove(toDelete);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentState>> Get()
        {
            return await _context.equipment_state.ToListAsync();
        }

        public async Task<EquipmentState> Get(Guid id)
        {
            return await _context.equipment_state.FindAsync(id);
        }

        public async Task Update(EquipmentState equipment)
        {
            _context.Entry(equipment).State = EntityState.Modified;
            await _context.SaveChangesAsync();            
        }
    }
}
