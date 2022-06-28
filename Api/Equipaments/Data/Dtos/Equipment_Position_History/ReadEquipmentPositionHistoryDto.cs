using System;
using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment_Position_History
{
    public class ReadEquipmentPositionHistoryDto
    {
        [Required]
        [Key]
        public Guid equipment_id { get; set; }
        public string date { get; set; }
        public double lat { get; set; }
        public double lon { get; set; }
    }
}
