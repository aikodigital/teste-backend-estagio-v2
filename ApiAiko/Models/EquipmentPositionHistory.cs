namespace api.Models
{
    public class EquipmentPositionHistory
    {
        public string? equipment_id { get; set; }
        public DateTime? date { get; set; }
        public float? lat { get; set; }
        public float? lon { get; set; }
    }
}
