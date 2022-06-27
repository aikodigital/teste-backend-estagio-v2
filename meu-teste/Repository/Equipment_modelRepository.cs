using Microsoft.EntityFrameworkCore;
using equipment_model.Data;
using equipment_model.Model;

namespace equipment_model.Repository
{
    public class Equipment_modelRepository : IEquipment_modelRepository
    {
        private readonly Equipment_modelContext _context;

        public Equipment_modelRepository(Equipment_modelContext context)
        {
            _context = context;
        }
        
        public async Task<IEnumerable<Equipment_model>> BuscaEquipment_models()
        {
            return await _context.Equipment_models.ToListAsync();
        }
        public async Task<Equipment_model> BuscaEquipment_model(Guid id)
        {
            return await _context.Equipment_models.Where(x => x.Id == id).FirstOrDefaultAsync();
        }
        
        public void AdicionaEquipment_model(Equipment_model equipment_model)
        {
            _context.Add(equipment_model);
        }

        public void AtualizaEquipment_model(Equipment_model equipment_model)
        {
            _context.Update(equipment_model);
        }


        public void DeletaEquipment_model(Equipment_model equipment_model)
        {
            _context.Remove(equipment_model);
        }

        public async Task<bool> SaveChangesAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }
    }
}