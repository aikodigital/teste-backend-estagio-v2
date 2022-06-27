using System;
using System.Collections.Generic;

namespace Aiko_ProcessoSeletivo_WebApi.Domains
{
    public partial class EquipmentState
    {
        public Guid Id { get; set; }
        public string Name { get; set; } = null!;
        public string Color { get; set; } = null!;
    }
}
