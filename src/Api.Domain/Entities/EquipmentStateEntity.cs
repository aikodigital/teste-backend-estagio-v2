using Api.Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class EquipmentStateEntity : BaseEntity
    {
        public string Name { get; set; }
        public string Color { get; set; }
        public virtual List<EquipmentModelStateHourlyEarningsEntity>EquipmentModelStateHourlyEarnings { get; set; }
        public virtual List<EquipmentStateHistoryEntity> EquipmentStateHistory { get; set; }

    }
}
