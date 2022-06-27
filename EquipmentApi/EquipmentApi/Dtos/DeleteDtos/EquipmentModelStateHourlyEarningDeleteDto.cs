using System;

namespace EquipmentApi.Dtos.DeleteDtos
{
    public class EquipmentModelStateHourlyEarningDeleteDto
    {
        public Guid EquipmentModelId { get; set; }
        public Guid EquipmentStateId { get; set; }
    }
}
