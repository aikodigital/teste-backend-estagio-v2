namespace Equipments.Domain.Entities
{
    public class EquipmentHourlyEarnings
    {
        public Guid EquipmentModelId { get; private set; }
        public Guid EquipmentStateId { get; private set; }
        public decimal Value { get; private set; }

        public EquipmentHourlyEarnings(Guid equipmentModelId, Guid equipmentStateId, decimal value)
        {
            EquipmentModelId = equipmentModelId;
            EquipmentStateId = equipmentStateId;
            Value = value;
        }

        public void EditValue(decimal value) => Value = value;
    }
}
