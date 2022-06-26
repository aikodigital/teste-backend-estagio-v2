using Equipments.Domain.Commands.Interface;
using Flunt.Notifications;
using Flunt.Validations;

namespace Equipments.Domain.Commands 
{ 
    public class CreateEquipmentCommand : Notifiable, ICommand
    {
        public string Name { get; private set; }
        public Guid EquipmentModelId { get; private set; }

        public CreateEquipmentCommand(string name, Guid equipmentModelId)
        {
            Name = name;
            EquipmentModelId = equipmentModelId;
        }

        public void Validate()
        {
            AddNotifications(new Contract().Requires().IsGreaterThan(Name.Length, 2, "Name", "O nome deve ser maior que 2 caracteres"));
        }
    }
}
