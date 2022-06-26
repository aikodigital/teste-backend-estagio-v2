using Equipments.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Equipments.Infra.Context.Mappings
{
    public class EquipmentPositionHistoryMap : IEntityTypeConfiguration<EquipmentPositionHistory>
    {
        public void Configure(EntityTypeBuilder<EquipmentPositionHistory> builder)
        {
            builder.ToTable("equipment_position_history");

            builder.HasNoKey();

            builder.Property(x => x.EquipmentId).IsRequired().HasColumnName("equipment_id").HasColumnType("uuid");
            builder.Property(x => x.Date).IsRequired().HasColumnName("date").HasColumnType("timestamp");
            builder.Property(x => x.Longitude).IsRequired().HasColumnName("lon").HasColumnType("real");
            builder.Property(x => x.Latitude).IsRequired().HasColumnName("lat").HasColumnType("real");
        }
    }
}
