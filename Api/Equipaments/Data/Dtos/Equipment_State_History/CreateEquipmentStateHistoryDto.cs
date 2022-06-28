using System;
using System.Text.Json.Serialization;

namespace Equipments.Data.Dtos.Equipment_State_History
{
    public class CreateEquipmentStateHistoryDto
    {
        public Guid equipment_id { get; set; }
        public Guid equipment_state_id { get; set; }
        [JsonIgnore]
        public DateTime date { get; set; } = DateTime.Now;
    }
}
