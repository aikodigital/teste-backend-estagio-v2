using System;

namespace EquipmentApi.Dtos.CreateDtos
{
    public class EquipmentCreateDto
    {
        public Guid Id { get; set; }
        public Guid EquipmentModelId { get; set; }
        public string Name { get; set; }
    }
}
