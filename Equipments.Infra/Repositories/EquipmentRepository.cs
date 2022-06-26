using Equipments.Domain.Entities;
using Equipments.Domain.Repositories;
using Equipments.Infra.Context;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Infra.Repositories
{
    public class EquipmentRepository : IEquipmentRepository
    {
        private readonly EquipmentsContext _context;

        public EquipmentRepository(EquipmentsContext context)
        {
            _context = context;
        }

        public async Task CreateAsync(Equipment Equipment)
        {
            await _context.Equipments.AddAsync(Equipment);
            await _context.SaveChangesAsync();
        }

        public async Task DeleteAsync(Equipment Equipment)
        {
            _context.Equipments.Remove(Equipment);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<Equipment>> GetAllAsync()
        {
            return await _context.Equipments.AsNoTracking().ToListAsync();
        }

        public async Task<Equipment> GetByIdAsync(Guid Id)
        {
            return await _context.Equipments.Where(x => x.Id == Id).FirstOrDefaultAsync();
        }

        public async Task UpdateAsync(Equipment Equipment)
        {
            _context.Entry(Equipment).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
