using System;

namespace EquipmentApi.Dtos.DeleteDtos
{
    public class EquipmentStateHistoryDeleteDto
    {
        public Guid EquipmentId { get; set; }
        public Guid EquipmentStateId { get; set; }
    }
}
