using Equipments.Domain.Commands.Interface;
using Flunt.Notifications;
using Flunt.Validations;

namespace Equipments.Domain.Commands
{
    public class CreateEquipmentModelCommand : Notifiable, ICommand
    {
        public string Name { get; private set; }

        public CreateEquipmentModelCommand(string name)
        {
            Name = name;
        }

        public void Validate()
        {
            AddNotifications(new Contract()
                .Requires()
                .IsGreaterThan(Name.Length, 2, "Name", "O nome deve ser maior que 2 caracteres"));
        }
    }
}
