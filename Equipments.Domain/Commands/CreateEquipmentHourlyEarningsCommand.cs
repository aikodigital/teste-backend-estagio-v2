using Equipments.Domain.Commands.Interface;
using Flunt.Notifications;
using Flunt.Validations;

namespace Equipments.Domain.Commands
{
    public class CreateEquipmentHourlyEarningsCommand : Notifiable, ICommand
    {
        public Guid EquipmentModelId { get; private set; }
        public Guid EquipmentStateId { get; private set; }
        public decimal Value { get; private set; }

        public CreateEquipmentHourlyEarningsCommand(Guid equipmentModelId, Guid equipmentStateId, decimal value)
        {
            EquipmentModelId = equipmentModelId;
            EquipmentStateId = equipmentStateId;
            Value = value;
        }

        public void Validate()
        {
            AddNotifications(new Contract().Requires().IsNotNull(Value, "Value", "Valor não pode ser nulo"));
        }
    }
}
