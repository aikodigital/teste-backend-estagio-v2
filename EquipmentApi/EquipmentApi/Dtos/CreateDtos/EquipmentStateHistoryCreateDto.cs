using System;

namespace EquipmentApi.Dtos.CreateDtos
{
    public class EquipmentStateHistoryCreateDto
    {
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public Guid EquipmentStateId { get; set; }
    }
}
