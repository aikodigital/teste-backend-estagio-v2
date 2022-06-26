using System.ComponentModel.DataAnnotations.Schema;

namespace Equipments.Domain.Entities
{
    public class EquipmentStateHistory
    {
        public Guid EquipmentId { get; private set; }
        public Guid EquipmentStateId { get; private set; }
        public DateTime Date { get; private set; }


        public EquipmentStateHistory(Guid equipmentId, Guid equipmentStateId, DateTime date)
        {
            EquipmentId = equipmentId;
            EquipmentStateId = equipmentStateId;
            Date = date;
        }
    }
}
