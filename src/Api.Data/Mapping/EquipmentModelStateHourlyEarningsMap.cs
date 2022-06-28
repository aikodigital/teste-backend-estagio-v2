using Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Mapping
{
    public class EquipmentModelStateHourlyEarningsMap : IEntityTypeConfiguration<EquipmentModelStateHourlyEarningsEntity>
    { 
        public void Configure(EntityTypeBuilder<EquipmentModelStateHourlyEarningsEntity> builder)
    {
            builder.ToTable("equipment_model_state_hourly_earnings");

            builder.HasKey(u => u.Id);

            builder.Property(u => u.Value)
                    .IsRequired();
        }
    }
}

 

