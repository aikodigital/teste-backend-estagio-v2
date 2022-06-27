namespace AikoCRUDAPI.Models
{
    public class EquipmentStateHistory
    {
        public Guid equipment_id { get; set; }
        public DateTime date { get; set; }
        public Guid equipment_state_id { get; set; }
    }
}
