using Equipments.Domain.Entities;

namespace Equipments.Domain.Repositories
{
    public interface IEquipmentModelRepository
    {
        Task CreateAsync(EquipmentModel equipmentModel);
        Task UpdateAsync(EquipmentModel equipmentModel);
        Task DeleteAsync(EquipmentModel equipmentModel);
        Task<EquipmentModel> GetByIdAsync(Guid Id);
        Task<IEnumerable<EquipmentModel>> GetAllAsync();
    }
}
