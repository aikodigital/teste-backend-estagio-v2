using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Equipments.Models
{
    public class Equipment
    {
        [Key]
        [Required]
        public Guid id { get; set; }
        public string name { get; set; }
        [Required]
        public Guid equipment_model_id { get; set; }
        [JsonIgnore]
        public virtual Equipment_Model equipment_model { get; set; }

        [JsonIgnore]
        public virtual List<Equipment_State_History> equipmentStateHistories { get; set; }


    }
}
