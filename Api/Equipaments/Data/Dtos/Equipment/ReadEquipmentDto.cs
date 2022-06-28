using Equipments.Models;
using System;
using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment
{
    public class ReadEquipmentDto
    {
        [Key]
        [Required]
        public Guid id { get; set; }
        public string name { get; set; }
        public Equipment_Model equipment_model { get; set; }
    }
}
