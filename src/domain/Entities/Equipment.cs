using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.domain.Common;

namespace TesteEstágioBackendV2.src.domain
{
    [Table("equipment")]
    public class Equipment : AuditableBaseModel
    {
        
        public Guid id { get; set; }
        public string name{get; set;}
        public Guid equipmentModel { get; set; }
        [ForeignKey("equipmentModel")]
        public EquipmentModel  EquipmentModel { get; set; }

        

        
    }
}