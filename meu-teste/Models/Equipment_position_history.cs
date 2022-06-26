namespace equipment_position_history.Model
{
    public class Equipment_position_history
    {
        public int id;
        public Guid Equipment_id { get; set; }
        public DateTime Date { get; set; }
        public Single Lat { get; set; }
        public Single Lon { get; set; }
    }
}