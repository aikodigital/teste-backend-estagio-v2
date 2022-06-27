namespace Aiko_ProcessoSeletivo_WebApi.ViewModel
{
    public class EquipmentStateHistoryViewModel
    {
        public Guid EquipmentId { get; set; }
        public Guid EquipmentStateId { get; set; }
        public DateTime Date { get; set; }
        public Guid NovoEquipmentStateId { get; set; }
    }
}
