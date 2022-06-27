using EquipmentApi.Entities;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Interfaces
{
    public interface IEquipmentRepository
    {
        public Task<Equipment> AddAsync(Equipment entity);
        public Task<Equipment> UpdateAsync(Equipment entity);
        public Task<bool> DeleteAsync(Guid id);
        public Task<IEnumerable<Equipment>> GetAllAsync();
        public Task<Equipment> GetByIdAsync(Guid id);
        public Task<IEnumerable<Equipment>> GetEquipmentsByModelId(Guid id);
    }
}
