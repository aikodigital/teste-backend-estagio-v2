using System;
using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment
{
    public class ReadEquipmentModelDto
    {
        [Key]
        [Required]
        public Guid id { get; set; }
        public string name { get; set; }
    }
}
