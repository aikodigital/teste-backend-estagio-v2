using AikoCRUDAPI.Models;

namespace AikoCRUDAPI.Repositories
{
    public interface IEquipmentsModelStateHourlyEarningsRepos
    {
        Task<IEnumerable<EquipmentModelStateHourlyEarnings>> Get();
        Task<EquipmentModelStateHourlyEarnings> Get(Guid id);
        Task<EquipmentModelStateHourlyEarnings> Create(EquipmentModelStateHourlyEarnings equipment);
        Task Update(EquipmentModelStateHourlyEarnings equipment);
        Task Delete(Guid id);
    }
}
