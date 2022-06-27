using EquipmentApi.Entities;
using System;

namespace EquipmentApi.Dtos.ReadDtos
{
    public class EquipmentModelStateHourlyEarningDto
    {
        public Guid EquipmentModelId { get; set; }
        public Guid EquipmentStateId { get; set; }
        public float Value { get; set; }

        public EquipmentModelShowDto EquipmentModel { get; set; }
        public EquipmentState EquipmentState { get; set; }
    }
}
