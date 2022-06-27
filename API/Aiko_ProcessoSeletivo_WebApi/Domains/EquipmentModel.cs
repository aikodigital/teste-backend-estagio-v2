using System;
using System.Collections.Generic;

namespace Aiko_ProcessoSeletivo_WebApi.Domains
{
    public partial class EquipmentModel
    {
        public EquipmentModel()
        {
            Equipment = new HashSet<Equipment>();
        }

        public Guid Id { get; set; }
        public string Name { get; set; } = null!;

        public virtual ICollection<Equipment> Equipment { get; set; }
    }
}
