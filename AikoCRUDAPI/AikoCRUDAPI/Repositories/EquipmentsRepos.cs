using AikoCRUDAPI.Models;
using Microsoft.EntityFrameworkCore;
using Npgsql;

namespace AikoCRUDAPI.Repositories
{
    public class EquipmentsRepos : IEquipmentsRepos
    {
        private readonly EquipmentContext _context;
        
        public EquipmentsRepos(EquipmentContext context)
        {
            _context = context;
        }
        public async Task<Equipment> Create(Equipment value)
        {
           _context.equipment.Add(value);            
           await _context.SaveChangesAsync();
            return value;
        }
        public async Task Delete(Guid id)
        {
            var toDelete = _context.equipment.Find(id);            
            _context.equipment.Remove(toDelete);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<Equipment>> Get()
        {
            return await _context.equipment.ToListAsync();
        }

        public async Task<Equipment> Get(Guid id)
        {
            return await _context.equipment.FindAsync(id);
        }

        public async Task Update(Equipment equipment)
        {
            _context.Entry(equipment).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
