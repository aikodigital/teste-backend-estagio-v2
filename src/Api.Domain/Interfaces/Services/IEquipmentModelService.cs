using Domain.Dtos.Equipment;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Interfaces.Services
{
    public interface IEquipmentModelService
    {
        Task<EquipmentModelDto> Get(Guid id);
        Task<IEnumerable<EquipmentModelDto>> GetAll();
        Task<EquipmentModelDto> Post(EquipmentModelDto equipment);
        Task<EquipmentModelDto> Put(EquipmentModelDto equipment);
        Task<bool> Delete(Guid id);
    }
}
