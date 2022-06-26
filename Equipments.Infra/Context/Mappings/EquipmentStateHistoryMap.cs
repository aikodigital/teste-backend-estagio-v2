using Equipments.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Equipments.Infra.Context.Mappings
{
    public class EquipmentStateHistoryMap : IEntityTypeConfiguration<EquipmentStateHistory>
    {
        public void Configure(EntityTypeBuilder<EquipmentStateHistory> builder)
        {
            builder.ToTable("equipment_state_history");

            builder.HasNoKey();

            builder.Property(x => x.EquipmentId).IsRequired().HasColumnName("equipment_id").HasColumnType("uuid");
            builder.Property(x => x.EquipmentStateId).IsRequired().HasColumnName("equipment_state_id").HasColumnType("uuid");
            builder.Property(x => x.Date).IsRequired().HasColumnName("date").HasColumnType("timestamp");

        }
    }
}
