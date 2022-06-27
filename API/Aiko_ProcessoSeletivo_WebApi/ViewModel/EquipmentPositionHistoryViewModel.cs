namespace Aiko_ProcessoSeletivo_WebApi.ViewModel
{
    public class EquipmentPositionHistoryViewModel
    {
        public Guid EquipmentId { get; set; }
        public DateTime Date { get; set; }
        public float Lat { get; set; }
        public float Lon { get; set; }
        public float NovoLat { get; set; }
        public float NovoLon { get; set; }
    }
}
