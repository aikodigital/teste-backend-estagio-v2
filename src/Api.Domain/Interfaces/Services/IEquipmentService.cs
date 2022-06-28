using Domain.Dtos.Equipments;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Interfaces.Services
{
    public interface IEquipmentService
    {
        Task<EquipmentDto> Get(Guid id);
        Task<IEnumerable<EquipmentDto>> GetAll();
        Task<EquipmentDto> Post(EquipmentDto equipment);
        Task<EquipmentDto> Put(EquipmentDto equipment);
        Task<bool> Delete(Guid id);
    }
}
