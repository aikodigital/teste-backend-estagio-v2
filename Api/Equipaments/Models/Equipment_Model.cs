using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Equipments.Models
{
    public class Equipment_Model
    {
        [Key]
        [Required]
        public Guid id { get; set; }
        public string name { get; set; }
        [JsonIgnore]
        public virtual List<Equipment> equipments { get; set; }
        [JsonIgnore]
        public virtual List<Equipment_Model_State_Hourly_Earnings> hourlyEarnings { get; set; }
    }
}
