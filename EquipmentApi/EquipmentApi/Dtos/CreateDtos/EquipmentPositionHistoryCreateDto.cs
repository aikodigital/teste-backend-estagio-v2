using System;

namespace EquipmentApi.Dtos.CreateDtos
{
    public class EquipmentPositionHistoryCreateDto
    {
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public float Lat { get; set; }
        public float Lon { get; set; }
    }
}
