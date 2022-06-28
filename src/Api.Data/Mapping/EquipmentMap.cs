using Api.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Mapping
{
    public class EquipmentMap :  IEntityTypeConfiguration<EquipmentEntity>
    {
        public void Configure(EntityTypeBuilder<EquipmentEntity> builder)
        {
            builder.ToTable("equipment");

            builder.HasKey(u => u.Id);

            builder.Property(u => u.Name)
                    .IsRequired()
                    .HasMaxLength(60);
            builder.HasMany(p => p.EquipmentStateHistory)
                .WithOne(o => o.Equipment).HasForeignKey(f => f.EquipmentId);
            builder.HasMany(p => p.EquipmentPositionHistory)
                .WithOne(o => o.Equipment).HasForeignKey(f => f.EquipmentId);
        }
    }
}


