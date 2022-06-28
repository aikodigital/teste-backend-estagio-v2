using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Dtos.Equipment
{
    public class EquipmentModelStateHourlyEarningsDto
    {
        public Guid Id { get; set; }
        public Guid EquipmentModelId { get; set; }
        public virtual EquipmentModelDto EquipmentModel { get; set; }
        public Guid EquipmentStateId { get; set; }
        public virtual EquipmentStateDto EquipmentState { get; set; }
        public decimal Value { get; set; }
        public DateTime CreatAt { get; set; }
    }
}
