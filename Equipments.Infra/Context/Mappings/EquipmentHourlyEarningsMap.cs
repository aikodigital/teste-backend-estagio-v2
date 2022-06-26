using Equipments.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Equipments.Infra.Context.Mappings
{
    internal class EquipmentHourlyEarningsMap : IEntityTypeConfiguration<EquipmentHourlyEarnings>
    {
        public void Configure(EntityTypeBuilder<EquipmentHourlyEarnings> builder)
        {
            builder.ToTable("equipment_model_state_hourly_earnings");

            builder.HasNoKey();

            builder.Property(x => x.EquipmentModelId).IsRequired().HasColumnName("equipment_model_id").HasColumnType("uuid");
            builder.Property(x => x.EquipmentStateId).IsRequired().HasColumnName("equipment_state_id").HasColumnType("uuid");
            builder.Property(x => x.Value).IsRequired().HasColumnName("value").HasColumnType("real");
        }
    }
}
