using AikoCRUDAPI.Models;

namespace AikoCRUDAPI.Repositories
{
    public interface IEquipmentsStateRepos
    {
        Task<IEnumerable<EquipmentState>> Get();
        Task<EquipmentState> Get(Guid id);
        Task<EquipmentState> Create(EquipmentState equipment);
        Task Update(EquipmentState equipment);
        Task Delete(Guid id);
    }
}
