
using Equipments.Models;
using System;
using System.Text.Json.Serialization;

namespace Equipments.Data.Dtos.Equipment_Model_State_Hourly_earnings
{
    public class ReadEquipmentModelStateHourlyEarningsDto
    {
        [JsonIgnore]
        public Guid equipment_model_id { get; set; }
        [JsonIgnore]
        public Guid equipment_state_id { get; set; }
        public virtual Equipment_Model equipment_model { get; set; }

        public virtual Models.Equipment_State equipment_state { get; set; }
        public double value { get; set; }

    }
}
