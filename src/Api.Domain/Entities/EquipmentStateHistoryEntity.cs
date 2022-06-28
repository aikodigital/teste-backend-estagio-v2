using Api.Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class EquipmentStateHistoryEntity : BaseEntity
    {
        public DateTime Date { get; set; }
        public Guid EquipmentStateId { get; set; }
        public virtual EquipmentStateEntity EquipmentState { get; set; }
        public Guid EquipmentId { get; set; }
        public virtual EquipmentEntity Equipment { get; set; }
    }
}
