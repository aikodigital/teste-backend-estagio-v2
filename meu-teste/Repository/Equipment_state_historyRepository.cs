using Microsoft.EntityFrameworkCore;
using equipment_state_history.Data;
using equipment_state_history.Model;

namespace equipment_state_history.Repository
{
    public class Equipment_state_historyRepository : IEquipment_state_historyRepository
    {
        private readonly Equipment_state_historyContext _context;

        public Equipment_state_historyRepository(Equipment_state_historyContext context)
        {
            _context = context;
        }
        
        public async Task<IEnumerable<Equipment_state_history>> BuscaEquipment_state_historys()
        {
            return await _context.Equipment_state_historys.ToListAsync();
        }
        public async Task<Equipment_state_history> BuscaEquipment_state_history(int equipment_id, int equipment_state_id)
        {
            return await _context.Equipment_state_historys.Where(x => (x.Equipment_id == equipment_id & x.Equipment_state_id == equipment_state_id)).OrderBy(x => x.Date).LastOrDefaultAsync();
        }
        
        public void AdicionaEquipment_state_history(Equipment_state_history equipment_state_history)
        {
            _context.Add(equipment_state_history);
        }

        public void AtualizaEquipment_state_history(Equipment_state_history equipment_state_history)
        {
            _context.Update(equipment_state_history);
        }


        public void DeletaEquipment_state_history(Equipment_state_history equipment_state_history)
        {
            _context.Remove(equipment_state_history);
        }

        public async Task<bool> SaveChangesAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }
    }
}