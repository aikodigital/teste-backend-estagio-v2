using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using EquipmentApi.Entities;

namespace EquipmentApi.Data.Interfaces
{
    public interface IEquipmentModelStateHourlyEarningRepository
    {
        public Task<EquipmentModelStateHourlyEarning> AddAsync(EquipmentModelStateHourlyEarning entity);
        public Task<EquipmentModelStateHourlyEarning> UpdateAsync(EquipmentModelStateHourlyEarning entity);
        public Task<bool> DeleteAsync(EquipmentModelStateHourlyEarning entity);
        public Task<IEnumerable<EquipmentModelStateHourlyEarning>> GetAllAsync();
        public Task<IEnumerable<EquipmentModelStateHourlyEarning>> GetByModelIdAsync(Guid id);
        public Task<IEnumerable<EquipmentModelStateHourlyEarning>> GetByStateIdAsync(Guid id);
    }
}
