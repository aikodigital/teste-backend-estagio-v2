using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.domain.Common;

namespace TesteEstágioBackendV2.src.domain
{
    [Table("EquipmentModelStateHourlyEarnings")]
    public class EquipmentModelStateHourlyEarnings : AuditableBaseModel
    {
        public Guid id { get; set; }
        public Guid equipmentModel { get; set; }
        [ForeignKey("equipmentModel")]
        public EquipmentModel EquipmentModel { get; set; }

        public int equipmentState { get; set; }
        [ForeignKey("equipmentState")]
        public EquipmentState EquipmentState { get; set; }

        public double value { get; set; }


    }
}