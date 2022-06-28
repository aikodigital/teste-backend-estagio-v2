using System;
using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment
{
    public class CreateEquipmentDto
    {
        [Required(ErrorMessage = "The field name is required")]
        public string name { get; set; }
        public Guid equipment_model_id { get; set; }
    }
}
