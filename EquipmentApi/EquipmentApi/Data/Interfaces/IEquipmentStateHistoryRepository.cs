using EquipmentApi.Entities;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Interfaces
{
    public interface IEquipmentStateHistoryRepository
    {
        public Task<EquipmentStateHistory> AddAsync(EquipmentStateHistory entity);
        public Task<EquipmentStateHistory> UpdateAsync(EquipmentStateHistory entity);
        public Task<bool> DeleteAsync(EquipmentStateHistory equipment);
        public Task<ICollection<EquipmentStateHistory>> GetAllAsync();
        public Task<IEnumerable<EquipmentStateHistory>> GetByEquipmentIdAsync(Guid id);
        public Task<IEnumerable<EquipmentStateHistory>> GetByEquipmentStateIdAsync(Guid id);
        public Task<IEnumerable<EquipmentStateHistory>> GetMostRecentEquipmentStateAsync();
        public Task<EquipmentStateHistory> GetMostRecentEquipmentStateByEquipmentIdAsync(Guid equipmentId);
    }
}
