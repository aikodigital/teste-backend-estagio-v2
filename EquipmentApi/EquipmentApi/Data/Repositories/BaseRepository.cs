using EquipmentApi.Data.Interfaces;
using EquipmentApi.Entities;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Repositories
{
    public class BaseRepository<T> : IBaseRepository<T> where T : BaseEntity
    {
        private readonly EquipmentDbContext _context;
        private readonly DbSet<T> _dbSet;

        public BaseRepository(EquipmentDbContext context)
        {
            _context = context;
            _dbSet = _context.Set<T>();
        }

        public async Task<T> AddAsync(T entity)
        {
            _dbSet.Add(entity);
            await _context.SaveChangesAsync();
            return entity;
        }

        public async Task<bool> DeleteAsync(Guid id)
        {
            var result = await _dbSet.FindAsync(id);
            _dbSet.Remove(result);
            return await _context.SaveChangesAsync() > 0;
        }

        public async Task<IEnumerable<T>> GetAllAsync()
        {
            IQueryable<T> result = _dbSet.AsNoTracking();
            return await result.ToListAsync();
        }

        public async Task<T> GetByIdAsync(Guid id)
        {
            var result = await _dbSet.FindAsync(id);
            return result;
        }

        public async Task<T> UpdateAsync(T entity)
        {
            var result = await _dbSet.FirstOrDefaultAsync(e => e.Id.Equals(entity.Id));
            if (result == null) throw new InvalidOperationException("Id not found");
            _dbSet.Update(entity);
            await _context.SaveChangesAsync();
            return entity;
        }
    }
}
