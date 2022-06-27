using System;

namespace EquipmentApi.Dtos.DeleteDtos
{
    public class EquipmentPositionHistoryDeleteDto
    {
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
    }
}
