using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment
{
    public class UpdateEquipmentDto
    {
        [Required(ErrorMessage = "O campo de nome é obrigatório")]
        public string name { get; set; }
    }
}
