using Microsoft.EntityFrameworkCore;
using equipment_model_state_hourly_earnings.Data;
using equipment_model_state_hourly_earnings.Model;

namespace equipment_model_state_hourly_earnings.Repository
{
    public class Equipment_model_state_hourly_earningsRepository : IEquipment_model_state_hourly_earningsRepository
    {
        private readonly Equipment_model_state_hourly_earningsContext _context;

        public Equipment_model_state_hourly_earningsRepository(Equipment_model_state_hourly_earningsContext context)
        {
            _context = context;
        }
        
        public async Task<IEnumerable<Equipment_model_state_hourly_earnings>> BuscaEquipment_model_state_hourly_earningss()
        {
            return await _context.Equipment_model_state_hourly_earningss.ToListAsync();
        }
        public async Task<Equipment_model_state_hourly_earnings> BuscaEquipment_model_state_hourly_earnings(Guid equipment_model_id, Guid equipment_state_id)
        {
            return await _context.Equipment_model_state_hourly_earningss.Where(x => (x.Equipment_model_id == equipment_model_id & x.Equipment_state_id == equipment_state_id)).FirstOrDefaultAsync();
        }
        
        public void AdicionaEquipment_model_state_hourly_earnings(Equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings)
        {
            _context.Add(equipment_model_state_hourly_earnings);
        }

        public void AtualizaEquipment_model_state_hourly_earnings(Equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings)
        {
            _context.Update(equipment_model_state_hourly_earnings);
        }


        public void DeletaEquipment_model_state_hourly_earnings(Equipment_model_state_hourly_earnings equipment_model_state_hourly_earnings)
        {
            _context.Remove(equipment_model_state_hourly_earnings);
        }

        public async Task<bool> SaveChangesAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }
    }
}