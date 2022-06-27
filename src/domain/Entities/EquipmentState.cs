using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.domain
{
    [Table("EquipmentState")]
    public class EquipmentState 
    {

           public int id { get; set; }
           public string name { get; set; }
        
           public string color { get; set; }


    }
}