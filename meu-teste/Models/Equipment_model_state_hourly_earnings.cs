namespace equipment_model_state_hourly_earnings.Model
{
    public class Equipment_model_state_hourly_earnings
    {
        public int id;
        public Guid Equipment_model_id { get; set; }
        public Guid Equipment_state_id { get; set; }
        public Single Value { get; set; }
    }
}