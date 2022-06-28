using Api.Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class EquipmentModelEntity : BaseEntity
    {
        public string Name { get; set; }
        public virtual List<EquipmentEntity> Equipment { get; set; }
        public virtual List<EquipmentModelStateHourlyEarningsEntity> EquipmentModelStateHourlyEarnings { get; set; }
    }
}
