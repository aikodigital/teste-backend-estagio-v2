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
    public class EquipmentStateMap : IEntityTypeConfiguration<EquipmentStateEntity>
    {
        public void Configure(EntityTypeBuilder<EquipmentStateEntity> builder)
        {
            builder.ToTable("equipment_state");

            builder.HasKey(u => u.Id);

            builder.Property(u => u.Name)
                    .IsRequired()
                    .HasMaxLength(60);

            builder.Property(u => u.Color)
                    .IsRequired()
                    .HasMaxLength(60);
            builder.HasMany(p => p.EquipmentStateHistory)
                .WithOne(o => o.EquipmentState).HasForeignKey(f => f.EquipmentStateId);
            builder.HasMany(p => p.EquipmentModelStateHourlyEarnings)
                .WithOne(o => o.EquipmentState).HasForeignKey(f => f.EquipmentStateId);
        }
    }
}
