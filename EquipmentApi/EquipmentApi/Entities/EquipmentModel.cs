using System;
using System.Collections.Generic;

#nullable disable

namespace EquipmentApi.Entities
{
    public class EquipmentModel : BaseEntity
    {
        public string Name { get; set; }
        public ICollection<Equipment> Equipment { get; set; }

    }
}
