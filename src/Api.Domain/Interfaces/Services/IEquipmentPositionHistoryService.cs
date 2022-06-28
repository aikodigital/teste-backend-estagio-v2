using Domain.Dtos.Equipment;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Interfaces.Services
{
    public interface IEquipmentPositionHistoryService
    {
        Task<EquipmentPositionHistoryDto> Get(Guid id);
        Task<IEnumerable<EquipmentPositionHistoryDto>> GetAll();
        Task<EquipmentPositionHistoryDto> Post(EquipmentPositionHistoryDto equipment);
        Task<EquipmentPositionHistoryDto> Put(EquipmentPositionHistoryDto equipment);
        Task<bool> Delete(Guid id);
        Task<EquipmentPositionHistoryDto> GetActualEquipment(Guid idEquipment);
    }
}
