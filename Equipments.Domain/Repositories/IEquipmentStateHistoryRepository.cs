using Equipments.Domain.Entities;

namespace Equipments.Domain.Repositories
{
    public interface IEquipmentStateHistoryRepository
    {
        Task CreateAsync(EquipmentStateHistory equipmentStateHistory);
        Task UpdateAsync(EquipmentStateHistory equipmentStateHistory);
        Task DeleteAsync(EquipmentStateHistory equipmentStateHistory);
        Task<IEnumerable<EquipmentStateHistory>> GetAllAsync();
        Task<IEnumerable<EquipmentStateHistory>> GetByIdAsync(Guid equipmentId);
    }
}
