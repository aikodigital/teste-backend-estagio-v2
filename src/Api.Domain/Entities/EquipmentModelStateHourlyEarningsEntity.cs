using Api.Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class EquipmentModelStateHourlyEarningsEntity : BaseEntity
    {
        public decimal Value { get; set; }
        public Guid EquipmentModelId { get; set; }
        public virtual EquipmentModelEntity EquipmentModel { get; set; }
        public Guid EquipmentStateId { get; set; }
        public virtual EquipmentStateEntity EquipmentState { get; set; }
    }
}
