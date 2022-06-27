using EquipmentApi.Entities;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Interfaces
{
    public interface IBaseRepository<T> where T : BaseEntity
    {
        public Task<T> AddAsync(T entity);
        public Task<T> UpdateAsync(T entity);
        public Task<bool> DeleteAsync(Guid id);
        public Task<IEnumerable<T>> GetAllAsync();
        public Task<T> GetByIdAsync(Guid id);
    }
}
