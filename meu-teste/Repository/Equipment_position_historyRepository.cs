using Microsoft.EntityFrameworkCore;
using equipment_position_history.Data;
using equipment_position_history.Model;

namespace equipment_position_history.Repository
{
    public class Equipment_position_historyRepository : IEquipment_position_historyRepository
    {
        private readonly Equipment_position_historyContext _context;

        public Equipment_position_historyRepository(Equipment_position_historyContext context)
        {
            _context = context;
        }
        
        public async Task<IEnumerable<Equipment_position_history>> BuscaEquipment_position_historys()
        {
            return await _context.Equipment_position_historys.ToListAsync();
        }
        public async Task<Equipment_position_history> BuscaEquipment_position_history(Guid equipment_id)
        {
            return await _context.Equipment_position_historys.Where(x => x.Equipment_id == equipment_id).OrderBy(x => x.Date).LastOrDefaultAsync();
        }
        
        public void AdicionaEquipment_position_history(Equipment_position_history equipment_position_history)
        {
            _context.Add(equipment_position_history);
        }

        public void AtualizaEquipment_position_history(Equipment_position_history equipment_position_history)
        {
            _context.Update(equipment_position_history);
        }


        public void DeletaEquipment_position_history(Equipment_position_history equipment_position_history)
        {
            _context.Remove(equipment_position_history);
        }

        public async Task<bool> SaveChangesAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }
    }
}