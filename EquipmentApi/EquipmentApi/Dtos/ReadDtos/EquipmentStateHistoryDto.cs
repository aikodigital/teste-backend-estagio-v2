using EquipmentApi.Entities;
using System;

namespace EquipmentApi.Dtos.ReadDtos
{
    public class EquipmentStateHistoryDto
    {
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public Guid EquipmentStateId { get; set; }

        public EquipmentDto Equipment { get; set; }
        public EquipmentStateWithoutIdDto EquipmentState { get; set; }
    }
}
