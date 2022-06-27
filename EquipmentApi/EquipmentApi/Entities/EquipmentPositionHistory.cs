using System;
using System.Collections.Generic;

#nullable disable

namespace EquipmentApi.Entities
{
    public class EquipmentPositionHistory
    {
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public float Lat { get; set; }
        public float Lon { get; set; }

        public Equipment Equipment { get; set; }
    }
}
