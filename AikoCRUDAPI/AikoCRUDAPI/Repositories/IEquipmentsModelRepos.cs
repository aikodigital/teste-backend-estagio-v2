using AikoCRUDAPI.Models;

namespace AikoCRUDAPI.Repositories
{
    public interface IEquipmentsModelRepos
    {
        Task<IEnumerable<EquipmentModel>> Get();
        Task<EquipmentModel> Get(Guid id);
        Task<EquipmentModel> Create(EquipmentModel equipment);
        Task Update(EquipmentModel equipment);
        Task Delete(Guid id);
    }
}
