using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Api.Domain.Entities
{
    public class EquipmentEntity : BaseEntity
    {        
        public Guid EquipmentModelId { get; set; }
        public virtual EquipmentModelEntity EquipmentModel { get; set; }
        public string Name { get; set; }
        public virtual List<EquipmentPositionHistoryEntity> EquipmentPositionHistory { get; set; }
        public virtual List<EquipmentStateHistoryEntity> EquipmentStateHistory { get; set; }
    }
}
