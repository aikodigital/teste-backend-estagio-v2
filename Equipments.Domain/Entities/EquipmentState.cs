

namespace Equipments.Domain.Entities
{
    public class EquipmentState :Entity
    {
        public string Name { get; private set; }
        public string Color { get; private set; }

        public EquipmentState(string name, string color)
        {
            Name = name;
            Color = color;
        }
        public void EditName(string name) => Name = name;
    }
}
