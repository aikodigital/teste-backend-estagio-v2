using System;
using System.Collections.Generic;

#nullable disable

namespace EquipmentApi.Entities
{
    public class EquipmentModelStateHourlyEarning
    {
        public Guid EquipmentModelId { get; set; }
        public Guid EquipmentStateId { get; set; }
        public float Value { get; set; }

        public EquipmentModel EquipmentModel { get; set; }
        public EquipmentState EquipmentState { get; set; }
    }
}
