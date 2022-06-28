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
    public class EquipmentStateRepository : BaseRepository<EquipmentStateEntity>, IEquipmentStateRepository
    {
        private DbSet<EquipmentStateEntity> _dataset;

        public EquipmentStateRepository(MyContext context) : base(context)
        {
            _dataset = context.Set<EquipmentStateEntity>();
        }
    }
}
