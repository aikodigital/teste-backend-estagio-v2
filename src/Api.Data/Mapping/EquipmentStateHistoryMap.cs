using Api.Domain.Entities;
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
    public class EquipmentStateHistoryMap : IEntityTypeConfiguration<EquipmentStateHistoryEntity>
    {
        public void Configure(EntityTypeBuilder<EquipmentStateHistoryEntity> builder)
        {
            builder.ToTable("equipment_state_history");

            builder.HasKey(u => u.Id);

            builder.Property(u => u.Date)
                    .IsRequired();
        }
    }
}