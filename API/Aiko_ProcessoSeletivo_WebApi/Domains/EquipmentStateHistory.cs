using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Aiko_ProcessoSeletivo_WebApi.Domains
{
    public partial class EquipmentStateHistory
    {
        [Key]
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public Guid EquipmentStateId { get; set; }

        public virtual Equipment Equipment { get; set; } = null!;
        public virtual EquipmentState EquipmentState { get; set; } = null!;
    }
}
