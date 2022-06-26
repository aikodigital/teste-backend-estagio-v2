using Equipments.Domain.Entities;

namespace Equipments.Domain.Repositories
{
    public interface IEquipmentStateRepository
    {
        Task CreateAsync(EquipmentState equipmentState);
        Task UpdateAsync(EquipmentState equipmentState);
        Task DeleteAsync(EquipmentState equipmentState);
        Task<IEnumerable<EquipmentState>> GetAllAsync();
        Task<EquipmentState> GetByIdAsync(Guid id);
    }
}
