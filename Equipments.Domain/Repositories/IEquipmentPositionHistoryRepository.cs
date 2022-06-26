using Equipments.Domain.Entities;

namespace Equipments.Domain.Repositories
{
    public interface IEquipmentPositionHistoryRepository
    {
        Task CreateAsync(EquipmentPositionHistory equipmentPositionHistory);
        Task UpdateAsync(EquipmentPositionHistory equipmentPositionHistory);
        Task DeleteAsync(EquipmentPositionHistory equipmentPositionHistory);
        Task<List<EquipmentPositionHistory>> GetAllAsync();
        Task<IEnumerable<EquipmentPositionHistory>> GetByIdAsync(Guid equipmentId);
    }
}
