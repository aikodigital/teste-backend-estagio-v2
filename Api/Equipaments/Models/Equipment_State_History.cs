using System;

namespace Equipments.Models
{
    public class Equipment_State_History
    {
        public Guid equipment_id { get; set; }
        public Guid equipment_state_id { get; set; }
        public virtual Equipment equipment { get; set; }
        public virtual Equipment_State equipment_state { get; set; }
        public DateTime date { get; set; }
    }
}
