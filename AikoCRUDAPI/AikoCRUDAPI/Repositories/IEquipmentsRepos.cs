using AikoCRUDAPI.Models;

namespace AikoCRUDAPI.Repositories
{
    public interface IEquipmentsRepos
    {
        Task<IEnumerable<Equipment>> Get();
        Task<Equipment> Get(Guid id);
        Task<Equipment> Create(Equipment equipment);
        Task Update(Equipment equipment);
        Task Delete(Guid id);
    }
}
