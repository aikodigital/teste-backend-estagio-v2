using Api.Domain.Entities;
using Api.Domain.Interfaces;
using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Repository
{
    public interface IEquipmentStateHistoryRepository : IRepository<EquipmentStateHistoryEntity>
    {
        Task<EquipmentStateHistoryEntity> GetActualEquipmentState(Guid idEquipment);
    }
}
