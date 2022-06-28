using Domain.Dtos.Equipment;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Interfaces.Services
{
    public interface IEquipmentStateHistoryService
    {
        Task<EquipmentStateHistoryDto> Get(Guid id);
        Task<IEnumerable<EquipmentStateHistoryDto>> GetAll();
        Task<EquipmentStateHistoryDto> Post(EquipmentStateHistoryDto equipment);
        Task<EquipmentStateHistoryDto> Put(EquipmentStateHistoryDto equipment);
        Task<bool> Delete(Guid id);
        Task<EquipmentStateHistoryDto> GetActualEquipment(Guid idEquipment);
    }
}
