using System;

namespace EquipmentApi.Dtos.ReadDtos
{
    public class EquipmentPositionHistoryDto
    {
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public float Lat { get; set; }
        public float Lon { get; set; }

        public EquipmentDto Equipment { get; set; }
    }
}
