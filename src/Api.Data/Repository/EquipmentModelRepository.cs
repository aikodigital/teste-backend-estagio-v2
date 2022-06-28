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
    public class EquipmentModelRepository : BaseRepository<EquipmentModelEntity>, IEquipmentModelRepository
    {
        private DbSet<EquipmentModelEntity> _dataset;

        public EquipmentModelRepository(MyContext context) : base(context)
        {
            _dataset = context.Set<EquipmentModelEntity>();
        }
    }
}
