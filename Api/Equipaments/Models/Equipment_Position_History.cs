using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Equipments.Models
{
    public class Equipment_Position_History
    {
        [Required]
        public Guid equipment_id { get; set; }
        [Required]
        public DateTime date { get; set; }
        [Required]
        public double lat{ get; set; }
        [Required]
        public double lon { get; set; }
    }
}
