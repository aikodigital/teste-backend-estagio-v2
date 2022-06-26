namespace Equipments.Domain.Entities
{
    public class EquipmentModel : Entity
    {
        public string Name { get; private set; }

        public EquipmentModel(string name)
        {
            Name = name;
        }

        public void EditName(string name) => Name = name;
    }
}
