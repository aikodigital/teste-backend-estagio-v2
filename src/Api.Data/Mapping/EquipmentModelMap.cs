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
    public class EquipmentModelMap : IEntityTypeConfiguration<EquipmentModelEntity>
    {
        public void Configure(EntityTypeBuilder<EquipmentModelEntity> builder)
        {
            builder.ToTable("equipment_model");

            builder.HasKey(u => u.Id);

            builder.Property(u => u.Name)
                    .IsRequired()
                    .HasMaxLength(60);
            builder.HasMany(p => p.Equipment)
                .WithOne(o => o.EquipmentModel).HasForeignKey(f => f.EquipmentModelId);
            builder.HasMany(p => p.EquipmentModelStateHourlyEarnings)
                .WithOne(o => o.EquipmentModel).HasForeignKey(f => f.EquipmentModelId);
        }
    }
}
