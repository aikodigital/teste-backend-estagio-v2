namespace equipment_position_history.Model
{
    public class Equipment_position_history
    {
        public int id;
        public int Equipment_id { get; set; }
        public DateTime Date { get; set; }
        public double Lat { get; set; }
        public double Lon { get; set; }
    }
}