using AikoCRUDAPI.Models;
using Microsoft.EntityFrameworkCore;
using Npgsql;

namespace AikoCRUDAPI.Repositories
{
    public class EquipmentsModelStateHourlyEarningsRepos : IEquipmentsModelStateHourlyEarningsRepos
    {
        private readonly EquipmentContext _context;
        
        public EquipmentsModelStateHourlyEarningsRepos(EquipmentContext context)
        {
            _context = context;
        }
        public async Task<EquipmentModelStateHourlyEarnings> Create(EquipmentModelStateHourlyEarnings value)
        {
           _context.equipment_model_state_hourly_earnings.Add(value);            
           await _context.SaveChangesAsync();
            return value;
        }
        public async Task Delete(Guid id)
        {
            var toDelete = _context.equipment_model_state_hourly_earnings.Find(id);            
            _context.equipment_model_state_hourly_earnings.Remove(toDelete);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentModelStateHourlyEarnings>> Get()
        {
            return await _context.equipment_model_state_hourly_earnings.ToListAsync();
        }

        public async Task<EquipmentModelStateHourlyEarnings> Get(Guid id)
        {
            return await _context.equipment_model_state_hourly_earnings.FindAsync(id);
        }

        public async Task Update(EquipmentModelStateHourlyEarnings equipment)
        {
            _context.Entry(equipment).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
