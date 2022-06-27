using EquipmentApi.Data.Interfaces;
using EquipmentApi.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Repositories
{
    public class EquipmentRepository : IEquipmentRepository
    {
        private readonly IBaseRepository<Equipment> _baseRepository;
        private readonly DbSet<Equipment> _dbSet;
        public EquipmentRepository(EquipmentDbContext context, IBaseRepository<Equipment> baseRepository)
        {
            _dbSet = context.Equipment;
            _baseRepository = baseRepository;
        }

        public async Task<Equipment> AddAsync(Equipment entity)
        {
            return await _baseRepository.AddAsync(entity);
        }

        public async Task<bool> DeleteAsync(Guid id)
        {
            return await _baseRepository.DeleteAsync(id);
        }

        public async Task<IEnumerable<Equipment>> GetAllAsync()
        {
            IQueryable<Equipment> query = _dbSet.AsNoTracking().Include(em => em.EquipmentModel);
            return await query.ToListAsync();
        }

        public async Task<Equipment> GetByIdAsync(Guid id)
        {
            var result = _dbSet.AsNoTracking().Include(em => em.EquipmentModel).FirstOrDefaultAsync(e => e.Id.Equals(id));
            return await result;
        }

        public async Task<Equipment> UpdateAsync(Equipment entity)
        {
            return await _baseRepository.UpdateAsync(entity);
        }

        public async Task<IEnumerable<Equipment>> GetEquipmentsByModelId(Guid id)
        {
            IQueryable<Equipment> query = _dbSet.Where(e => e.EquipmentModelId.Equals(id)).AsNoTracking().Include(em => em.EquipmentModel);
            return await query.ToListAsync();
        }
    }
}
