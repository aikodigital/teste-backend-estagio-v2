using System;
using System.Collections.Generic;

#nullable disable

namespace EquipmentApi.Entities
{
    public class Equipment : BaseEntity
    {
        public Guid EquipmentModelId { get; set; }
        public string Name { get; set; }

        public EquipmentModel EquipmentModel { get; set; }
    }
}
