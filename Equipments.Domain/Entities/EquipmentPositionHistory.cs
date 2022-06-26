
namespace Equipments.Domain.Entities
{
    public class EquipmentPositionHistory
    {
        public Guid EquipmentId { get; private set; }
        public DateTime Date { get; private set; }
        public long Latitude { get; private set; }
        public long Longitude { get; private set; }

        public EquipmentPositionHistory(Guid equipmentId, DateTime date, long latitude, long longitude)
        {
            EquipmentId = equipmentId;
            Date = date;
            Latitude = latitude;
            Longitude = longitude;
        }

        public void EditPosition(long latitude, long longitude) 
        {
            Latitude = latitude;
            Longitude = longitude;
            Date = DateTime.Now;
        }
    }
}
