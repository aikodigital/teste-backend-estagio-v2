namespace equipment_state_history.Model
{
    public class Equipment_state_history
    {
        public int id;
        public Guid Equipment_id { get; set; }
        public DateTime Date { get; set; }
        public Guid Equipment_state_id { get; set; }
    }
}