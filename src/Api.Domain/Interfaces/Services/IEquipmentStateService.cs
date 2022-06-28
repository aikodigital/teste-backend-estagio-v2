using Domain.Dtos.Equipment;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Interfaces.Services
{
    public interface IEquipmentStateService
    {
        Task<EquipmentStateDto> Get(Guid id);
        Task<IEnumerable<EquipmentStateDto>> GetAll();
        Task<EquipmentStateDto> Post(EquipmentStateDto equipment);
        Task<EquipmentStateDto> Put(EquipmentStateDto equipment);
        Task<bool> Delete(Guid id);
    }
}
