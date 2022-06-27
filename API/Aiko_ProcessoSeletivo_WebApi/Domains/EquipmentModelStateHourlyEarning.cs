using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace Aiko_ProcessoSeletivo_WebApi.Domains
{
    public partial class EquipmentModelStateHourlyEarning
    {
        [Key]
        public Guid EquipmentModelId { get; set; }
        public Guid EquipmentStateId { get; set; }
        public float Value { get; set; }

        
        public virtual EquipmentModel EquipmentModel { get; set; } = null!;
        public virtual EquipmentState EquipmentState { get; set; } = null!;
    }
}
