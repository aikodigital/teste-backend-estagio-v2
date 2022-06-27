namespace AikoCRUDAPI.Models
{
    public class EquipmentPositionHistory
    {
        public Guid equipment_id { get; set; }
        public DateTime date { get; set; }
        public double lat { get; set; }
        public double lon { get; set; }
    }
}
