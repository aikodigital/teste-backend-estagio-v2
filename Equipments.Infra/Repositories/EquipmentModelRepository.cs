using Equipments.Domain.Entities;
using Equipments.Domain.Repositories;
using Equipments.Infra.Context;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Infra.Repositories
{
    public class EquipmentModelRepository : IEquipmentModelRepository
    {
        private readonly EquipmentsContext _context;

        public EquipmentModelRepository(EquipmentsContext context)
        {
            _context = context;
        }

        public async Task CreateAsync(EquipmentModel equipmentModel)
        {
            await _context.EquipmentModel.AddAsync(equipmentModel);
            await _context.SaveChangesAsync();
        }

        public async Task DeleteAsync(EquipmentModel equipmentModel)
        {
            _context.EquipmentModel.Remove(equipmentModel);
            await _context.SaveChangesAsync();
        }

        public async Task<IEnumerable<EquipmentModel>> GetAllAsync()
        {
            return await _context
                .EquipmentModel
                .AsNoTracking()
                .ToListAsync();
        }

        public async Task<EquipmentModel> GetByIdAsync(Guid Id)
        {
           return await _context
                .EquipmentModel
                .AsNoTracking()
                .Where(x => x.Id == Id)
                .FirstOrDefaultAsync();
        }

        public async Task UpdateAsync(EquipmentModel equipmentModel)
        {
            _context.Entry(equipmentModel).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
    }
}
