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
    public class EquipmentPositionHistoryMap : IEntityTypeConfiguration<EquipmentPositionHistoryEntity>
    {
        public void Configure(EntityTypeBuilder<EquipmentPositionHistoryEntity> builder)
        {
            builder.ToTable("equipment_position_history");

            builder.HasKey(u => u.Id);

            builder.Property(u => u.Date)
                .IsRequired();

            builder.Property(u => u.Lat)
                .IsRequired();

            builder.Property(u => u.Lon)
                .IsRequired();
        }
    }
}
