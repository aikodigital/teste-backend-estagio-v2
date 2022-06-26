using Equipments.Domain.Entities;

namespace Equipments.Domain.Repositories
{
    public interface IEquipmentHourlyEarningsRepository
    {
        Task CreateAsync(EquipmentHourlyEarnings equipmentHourlyEarnings);
        Task UpdateAsync(EquipmentHourlyEarnings equipmentHourlyEarnings);
        Task DeleteAsync(EquipmentHourlyEarnings equipmentHourlyEarnings);
        Task<IEnumerable<EquipmentHourlyEarnings>> GetAllAsync();
        Task<IEnumerable<EquipmentHourlyEarnings>> GetByIdAsync(Guid equipmentModelId);
    }
}
