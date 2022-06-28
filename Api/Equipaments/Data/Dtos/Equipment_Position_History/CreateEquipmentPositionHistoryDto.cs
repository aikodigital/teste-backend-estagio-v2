using System;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Equipments.Data.Dtos.Equipment_Position_History
{
    public class CreateEquipmentPositionHistoryDto
    {
        [Required]
        [Key]
        public Guid equipment_id { get; set; }
        [JsonIgnore]
        public DateTime date = DateTime.Now;
        public double lat { get; set; }
        public double lon { get; set; }
    }
}
