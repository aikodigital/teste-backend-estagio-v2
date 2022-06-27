using Microsoft.EntityFrameworkCore;
using equipment_state.Data;
using equipment_state.Model;

namespace equipment_state.Repository
{
    public class Equipment_stateRepository : IEquipment_stateRepository
    {
        private readonly Equipment_stateContext _context;

        public Equipment_stateRepository(Equipment_stateContext context)
        {
            _context = context;
        }
        
        public async Task<IEnumerable<Equipment_state>> BuscaEquipment_states()
        {
            return await _context.Equipment_states.ToListAsync();
        }
        public async Task<Equipment_state> BuscaEquipment_state(Guid id)
        {
            return await _context.Equipment_states.Where(x => x.Id == id).FirstOrDefaultAsync();
        }
        
        public void AdicionaEquipment_state(Equipment_state equipment_state)
        {
            _context.Add(equipment_state);
        }

        public void AtualizaEquipment_state(Equipment_state equipment_state)
        {
            _context.Update(equipment_state);
        }


        public void DeletaEquipment_state(Equipment_state equipment_state)
        {
            _context.Remove(equipment_state);
        }

        public async Task<bool> SaveChangesAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }
    }
}