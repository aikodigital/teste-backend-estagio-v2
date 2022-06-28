using Api.Data.Context;
using Api.Domain.Entities;
using Domain.Repository;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Repository
{
    public class EquipmentRepository : BaseRepository<EquipmentEntity>, IEquipmentRepository
    {
        private DbSet<EquipmentEntity> _dataset;

        public EquipmentRepository(MyContext context) : base(context)
        {
            _dataset = context.Set<EquipmentEntity>();
        }
    }
}
