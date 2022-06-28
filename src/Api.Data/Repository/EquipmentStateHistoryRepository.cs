using Api.Data.Context;
using Domain.Entities;
using Domain.Repository;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Repository
{
    public class EquipmentStateHistoryRepository : BaseRepository<EquipmentStateHistoryEntity>, IEquipmentStateHistoryRepository
    {
        private DbSet<EquipmentStateHistoryEntity> _dataset;

        public EquipmentStateHistoryRepository(MyContext context) : base(context)
        {
            _dataset = context.Set<EquipmentStateHistoryEntity>();
        }

        public async Task<EquipmentStateHistoryEntity> GetActualEquipmentState(Guid idEquipment)
        {
            return await _dataset.Where(p => p.EquipmentId == idEquipment).Include(p => p.Equipment).OrderByDescending(o => o.Date).FirstOrDefaultAsync();
        }
    }
}

