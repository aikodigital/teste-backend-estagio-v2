using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment_State
{
    public class UpdateEquipmentStateDto
    {
        [Required(ErrorMessage = "The field name is required")]
        public string name { get; set; }
        [Required(ErrorMessage = "The field color is required")]
        public string color { get; set; }
    }
}
