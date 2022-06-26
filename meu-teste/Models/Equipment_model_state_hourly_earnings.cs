namespace equipment_model_state_hourly_earnings.Model
{
    public class Equipment_model_state_hourly_earnings
    {
        public int id;
        public int Equipment_model_id { get; set; }
        public int Equipment_state_id { get; set; }
        public double Value { get; set; }
    }
}