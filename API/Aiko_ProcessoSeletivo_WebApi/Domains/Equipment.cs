using System;
using System.Collections.Generic;

namespace Aiko_ProcessoSeletivo_WebApi.Domains
{
    public partial class Equipment
    {
        public Guid Id { get; set; }
        public Guid EquipmentModelId { get; set; }
        public string Name { get; set; } = null!;

        public virtual EquipmentModel EquipmentModel { get; set; } = null!;
    }
}
