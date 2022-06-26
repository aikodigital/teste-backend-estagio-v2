using Equipments.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Equipments.Infra.Context.Mappings
{
    public class EquipmentStateMap : IEntityTypeConfiguration<EquipmentState>
    {
        public void Configure(EntityTypeBuilder<EquipmentState> builder)
        {
            builder.ToTable("equipment_state");

            builder.HasKey(x => x.Id);

            builder.Property(x => x.Id).IsRequired().HasColumnName("id").HasColumnType("uuid");
            builder.Property(x => x.Name).IsRequired().HasColumnName("name").HasColumnType("text");
            builder.Property(x => x.Color).IsRequired().HasColumnName("color").HasColumnType("text");
        }
    }
}
