using System;

namespace EquipmentApi.Dtos.CreateDtos
{
    public class EquipmentModelStateHourlyEarningCreateDto
    {
        public Guid EquipmentModelId { get; set; }
        public Guid EquipmentStateId { get; set; }
        public float Value { get; set; }
    }
}
