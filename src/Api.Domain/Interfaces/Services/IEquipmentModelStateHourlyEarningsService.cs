using Domain.Dtos.Equipment;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Interfaces.Services.User
{
    public interface IEquipmentModelStateHourlyEarningsService
    {
        Task<EquipmentModelStateHourlyEarningsDto> Get(Guid id);
        Task<IEnumerable<EquipmentModelStateHourlyEarningsDto>> GetAll();
        Task<EquipmentModelStateHourlyEarningsDto> Post(EquipmentModelStateHourlyEarningsDto equipment);
        Task<EquipmentModelStateHourlyEarningsDto> Put(EquipmentModelStateHourlyEarningsDto equipment);
        Task<bool> Delete(Guid id);
    }
}
