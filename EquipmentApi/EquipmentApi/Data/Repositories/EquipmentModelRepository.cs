using EquipmentApi.Data.Interfaces;
using EquipmentApi.Entities;

namespace EquipmentApi.Data.Repositories
{
    public class EquipmentModelRepository : BaseRepository<EquipmentModel>, IEquipmentModelRepository
    {
        public EquipmentModelRepository(EquipmentDbContext context) : base(context)
        {
        }
    }
}
