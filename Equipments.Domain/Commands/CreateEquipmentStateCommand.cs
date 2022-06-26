using Equipments.Domain.Commands.Interface;
using Flunt.Notifications;
using Flunt.Validations;

namespace Equipments.Domain.Commands
{
    public class CreateEquipmentStateCommand : Notifiable, ICommand
    {
        public string Name { get; private set; }
        public string Color { get; private set; }

        public CreateEquipmentStateCommand(string name, string color)
        {
            Name = name;
            Color = color;
        }

        public void Validate()
        {
            AddNotifications(new Contract()
                .Requires()
                .IsGreaterThan(Name.Length, 2, "Name", "O nome deve ser maior que 2 caracteres")
                .IsGreaterThan(Color.Length, 2, "Name", "A cor deve ser maior que 2 caracteres"));
        }
    }
}
