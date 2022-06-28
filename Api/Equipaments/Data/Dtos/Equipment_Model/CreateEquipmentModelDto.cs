using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment
{
    public class CreateEquipmentModelDto
    {
        [Required(ErrorMessage = "The field name is required")]
        public string name { get; set; }
    }
}
