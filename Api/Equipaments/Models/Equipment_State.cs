using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Equipments.Models
{
    public class Equipment_State
    {
        [Required]
        [Key]
        public Guid id { get; set; }
        public string name { get; set; }
        public string color { get; set; }
        [JsonIgnore]
        public virtual List<Equipment_Model_State_Hourly_Earnings> hourlyEarnings { get; set; }
        [JsonIgnore]
        public virtual List<Equipment_State_History> equipmentStateHistories { get; set; }
    }
}
