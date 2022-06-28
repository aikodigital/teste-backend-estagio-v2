using Domain.Dtos.Equipments;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Dtos.Equipment
{
    public class EquipmentStateHistoryDto
    {
        public Guid Id { get; set; }
        public DateTime Date { get; set; }
        public DateTime CreatAt { get; set; }
        public Guid EquipmentId { get; set; }
        public virtual EquipmentDto Equipment { get; set; }
        public Guid EquipmentStateId { get; set; }
        public virtual EquipmentStateDto EquipmentState { get; set; }
    }
}
