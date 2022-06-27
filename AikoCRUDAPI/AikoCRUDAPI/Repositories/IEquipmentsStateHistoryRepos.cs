using AikoCRUDAPI.Models;

namespace AikoCRUDAPI.Repositories
{
    public interface IEquipmentsStateHistoryRepos
    {
        Task<IEnumerable<EquipmentStateHistory>> Get();
        Task<EquipmentStateHistory> Get(Guid id);
        Task<EquipmentStateHistory> Create(EquipmentStateHistory equipment);
        Task Update(EquipmentStateHistory equipment);
        Task Delete(Guid id);
    }
}
