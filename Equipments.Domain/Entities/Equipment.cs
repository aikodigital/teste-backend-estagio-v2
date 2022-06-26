namespace Equipments.Domain.Entities
{
    public class Equipment : Entity
    {
        public Guid EquipmentModelId { get; private set; }
        public string Name { get; private set; }

        public Equipment(Guid equipmentModelId, string name)
        {
            EquipmentModelId = equipmentModelId;
            Name = name;
        }

        public void EditName(string name) => Name = name;
    }
}
