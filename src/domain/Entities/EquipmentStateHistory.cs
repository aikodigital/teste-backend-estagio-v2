using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.domain.Common;

namespace TesteEstágioBackendV2.src.domain
{
    [Table("EquipmentStateHistory")]
    public class EquipmentStateHistory : AuditableBaseModel
    {
        public Guid id { get; set; }
        public Guid equipment { get; set; }
        [ForeignKey("equipment")]
        public Equipment Equipment{get; set;}

        public DateTime date {get; set;}


        public int equipmentState { get; set; }
        [ForeignKey("equipmentState")]
        public EquipmentState EquipmentState {get; set;}
    }
}