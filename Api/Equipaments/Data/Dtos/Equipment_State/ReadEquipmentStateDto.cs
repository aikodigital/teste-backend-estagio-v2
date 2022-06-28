using System;
using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment_State
{
    public class ReadEquipmentStateDto
    {
        [Required]
        [Key]
        public Guid id { get; set; }
        public string name { get; set; }
        public string color { get; set; }
    }
}
