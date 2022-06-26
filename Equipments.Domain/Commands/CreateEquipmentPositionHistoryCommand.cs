using Equipments.Domain.Commands.Interface;
using Flunt.Notifications;
using Flunt.Validations;

namespace Equipments.Domain.Commands
{
    public class CreateEquipmentPositionHistoryCommand : Notifiable, ICommand
    {
        public Guid EquipmentId { get; private set; }
        public DateTime Date { get; private set; }
        public long Latitude { get; private set; }
        public long Longitude { get; private set; }

        public CreateEquipmentPositionHistoryCommand(Guid equipmentId, DateTime date, long latitude, long longitude)
        {
            EquipmentId = equipmentId;
            Date = date;
            Latitude = latitude;
            Longitude = longitude;
        }

        public void Validate()
        {
            AddNotifications(new Contract()
                .Requires()
                .IsNotNull(Latitude, "latitude", "Latitude não pode ser nulo")
                .IsNotNull(Longitude, "Longitude", "Longitude não pode ser nulo"));
        }
    }
}
