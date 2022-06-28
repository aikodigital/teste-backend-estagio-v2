using System;
using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment_Position_History
{
    public class UpdateEquipmentPositionHistoryDto
    {
        [Required]
        [Key]
        public double lat { get; set; }
        public double lon { get; set; }
    }
}
