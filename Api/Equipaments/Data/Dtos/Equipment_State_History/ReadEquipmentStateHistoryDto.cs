using System;
using System.Text.Json.Serialization;

namespace Equipments.Data.Dtos.Equipment_State_History
{
    public class ReadEquipmentStateHistoryDto
    {
        [JsonIgnore]
        public Guid equipment_id { get; set; }
        [JsonIgnore]
        public Guid equipment_state_id { get; set; }
        public virtual Models.Equipment equipment { get; set; }
        public virtual Models.Equipment_State equipment_state { get; set; }
        public DateTime date { get; set; }
    }
}
