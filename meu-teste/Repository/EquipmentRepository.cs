using Microsoft.EntityFrameworkCore;
using equipment.Data;
using equipment.Model;

namespace equipment.Repository
{
    public class EquipmentRepository : IEquipmentRepository
    {
        private readonly EquipmentContext _context;

        public EquipmentRepository(EquipmentContext context)
        {
            _context = context;
        }
        
        public async Task<IEnumerable<Equipment>> BuscaEquipments()
        {
            return await _context.Equipments.ToListAsync();
        }
        public async Task<Equipment> BuscaEquipment(int id)
        {
            return await _context.Equipments.Where(x => x.Id == id).FirstOrDefaultAsync();
        }
        
        public void AdicionaEquipment(Equipment equipment)
        {
            _context.Add(equipment);
        }

        public void AtualizaEquipment(Equipment equipment)
        {
            _context.Update(equipment);
        }


        public void DeletaEquipment(Equipment equipment)
        {
            _context.Remove(equipment);
        }

        public async Task<bool> SaveChangesAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }
    }
}