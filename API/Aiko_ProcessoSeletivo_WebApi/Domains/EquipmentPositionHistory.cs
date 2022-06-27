using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace Aiko_ProcessoSeletivo_WebApi.Domains
{
    public partial class EquipmentPositionHistory
    {
        [Key]
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public float Lat { get; set; }
        public float Lon { get; set; }

        public virtual Equipment Equipment { get; set; } = null!;
    }
}
