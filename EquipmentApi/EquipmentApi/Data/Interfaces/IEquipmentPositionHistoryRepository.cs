using EquipmentApi.Entities;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace EquipmentApi.Data.Interfaces
{
    public interface IEquipmentPositionHistoryRepository
    {
        public Task<EquipmentPositionHistory> AddAsync(EquipmentPositionHistory entity);
        public Task<EquipmentPositionHistory> UpdateAsync(EquipmentPositionHistory entity);
        public Task<bool> DeleteAllEquipmentPositionHistoryAsync(Guid equipmentId);
        public Task<IEnumerable<EquipmentPositionHistory>> GetAllAsync();
        public Task<IEnumerable<EquipmentPositionHistory>> GetByIdAsync(Guid id);
        public Task<IEnumerable<EquipmentPositionHistory>> GetMostRecentEquipmentPositionAsync();
        public Task<EquipmentPositionHistory> GetMostRecentEquipmentPositionByEquipmentIdAsync(Guid equipmentId);
    }
}
