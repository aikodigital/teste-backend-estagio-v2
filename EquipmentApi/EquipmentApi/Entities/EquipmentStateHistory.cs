using System;
using System.Collections.Generic;

#nullable disable

namespace EquipmentApi.Entities
{
    public class EquipmentStateHistory
    {
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public Guid EquipmentStateId { get; set; }

        public Equipment Equipment { get; set; }
        public EquipmentState EquipmentState { get; set; }
    }
}
