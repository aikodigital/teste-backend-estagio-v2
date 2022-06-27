using AikoCRUDAPI.Models;
using Microsoft.EntityFrameworkCore;
using Npgsql;

namespace AikoCRUDAPI.Repositories
{
    public class EquipmentsModelRepos : IEquipmentsModelRepos
    {
        private readonly EquipmentContext _context;
        
        public EquipmentsModelRepos(EquipmentContext context)
        {
            _context = context;
        }
        public async Task<EquipmentModel> Create(EquipmentModel value)
        {
           _context.equipment_model.Add(value);            
           await _context.SaveChangesAsync();
            return value;
        }
        public async Task Delete(Guid id)
        {
            var toDelete = _context.equipment_model.Find(id);            
            _context.equipment_model.Remove(toDelete);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentModel>> Get()
        {
            return await _context.equipment_model.ToListAsync();
        }

        public async Task<EquipmentModel> Get(Guid id)
        {
            return await _context.equipment_model.FindAsync(id);
        }

        public async Task Update(EquipmentModel equipmentModel)
        {
            _context.Entry(equipmentModel).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
