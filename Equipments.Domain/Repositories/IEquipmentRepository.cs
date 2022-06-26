using Equipments.Domain.Entities;

namespace Equipments.Domain.Repositories
{
    public interface IEquipmentRepository
    {
        Task CreateAsync(Equipment Equipment);
        Task UpdateAsync(Equipment Equipment);
        Task DeleteAsync(Equipment Equipment);
        Task<Equipment> GetByIdAsync(Guid Id);
        Task<IEnumerable<Equipment>> GetAllAsync();
    }
}
