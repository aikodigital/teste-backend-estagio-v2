using System;

namespace Equipments.Models
{
    public class Equipment_Model_State_Hourly_Earnings
    {
        
        public Guid equipment_model_id { get; set; }
        public Guid equipment_state_id { get; set; }

        public virtual Equipment_Model equipment_model { get; set; }

        public virtual Equipment_State equipment_state { get; set; }
        public double value { get; set; }
    }
}
