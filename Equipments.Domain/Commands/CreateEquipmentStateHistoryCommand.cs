using Equipments.Domain.Commands.Interface;
using Flunt.Notifications;
using Flunt.Validations;

namespace Equipments.Domain.Commands
{
    public class CreateEquipmentStateHistoryCommand : Notifiable, ICommand
    {
        public Guid EquipmentId { get; private set; }
        public Guid EquipmentStateId { get; private set; }
        public DateTime Date { get; private set; }

        public CreateEquipmentStateHistoryCommand(Guid equipmentId, Guid equipmentStateId)
        {
            EquipmentId = equipmentId;
            EquipmentStateId = equipmentStateId;
            Date = DateTime.Now;
        }

        public void Validate()
        {
        }
    }
}
