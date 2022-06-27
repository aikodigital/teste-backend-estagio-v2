using AikoCRUDAPI.Models;

namespace AikoCRUDAPI.Repositories
{
    public interface IEquipmentsPositionHistoryRepos
    {
        Task<IEnumerable<EquipmentPositionHistory>> Get();
        Task<EquipmentPositionHistory> Get(Guid id);
        Task<EquipmentPositionHistory> Create(EquipmentPositionHistory equipment);
        Task Update(EquipmentPositionHistory equipment);
        Task Delete(Guid id);
    }
}
