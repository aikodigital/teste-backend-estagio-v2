using System;

namespace EquipmentApi.Dtos.ReadDtos
{
    public class EquipmentDto
    {
        public Guid Id { get; set; }
        public string Name { get; set; }

        public EquipmentModelShowDto EquipmentModel { get; set; }
    }
}
