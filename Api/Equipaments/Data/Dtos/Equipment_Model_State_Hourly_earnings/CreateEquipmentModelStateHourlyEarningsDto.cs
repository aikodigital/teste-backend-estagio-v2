using System;
using System.ComponentModel.DataAnnotations;

namespace Equipments.Data.Dtos.Equipment_Model_State_Hourly_earnings
{
    public class CreateEquipmentModelStateHourlyEarningsDto
    {
        [Required(ErrorMessage = "The field equipment_model_id is required")]
        public Guid equipment_model_id { get; set; }
        [Required(ErrorMessage = "The field equipment_state_id is required")]
        public Guid equipment_state_id { get; set; }
        [Required]
        public double value { get; set; }

    }
}
