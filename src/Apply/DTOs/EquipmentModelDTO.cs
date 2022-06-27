using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.Apply.DTOs
{
    public class EquipmentModelDTO
    {
       public Guid id { get; set; }
        public string name { get; set; }
        public DateTime Created { get; set; }
        public DateTime? LastModified { get; set; } 
    }
}