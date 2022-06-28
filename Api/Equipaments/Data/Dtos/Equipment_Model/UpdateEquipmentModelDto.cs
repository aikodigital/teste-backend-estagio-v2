using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment
{
    public class UpdateEquipmentModelDto
    {
        [Required(ErrorMessage = "O campo de nome é obrigatório")]
        public string name { get; set; }
    }
}
