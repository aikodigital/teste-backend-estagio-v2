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
    public class EquipmentModelStateHourlyEarningsRepository : BaseRepository<EquipmentModelStateHourlyEarningsEntity>, IEquipmentModelStateHourlyEarningsRepository
    {
        private DbSet<EquipmentModelStateHourlyEarningsEntity> _dataset;

        public EquipmentModelStateHourlyEarningsRepository(MyContext context) : base(context)
        {
            _dataset = context.Set<EquipmentModelStateHourlyEarningsEntity>();
        }
    }
}
