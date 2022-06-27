using EquipmentApi.Data.Interfaces;
using EquipmentApi.Entities;

namespace EquipmentApi.Data.Repositories
{
    public class EquipmentStateRepository : BaseRepository<EquipmentState>, IEquipmentStateRepository
    {
        public EquipmentStateRepository(EquipmentDbContext context) : base(context)
        {
        }
    }
}
