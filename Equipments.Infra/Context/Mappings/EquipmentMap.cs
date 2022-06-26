using Equipments.Domain.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Equipments.Infra.Context.Mappings
{
    public class EquipmentMap : IEntityTypeConfiguration<Equipment>
    {
        public void Configure(EntityTypeBuilder<Equipment> builder)
        {
            builder.ToTable("equipment");
            builder.HasKey(x => x.Id);

            builder.Property(x => x.Id).IsRequired().HasColumnName("id").HasColumnType("uuid");
            builder.Property(x => x.EquipmentModelId).IsRequired().HasColumnName("equipment_model_id").HasColumnType("uuid");
            builder.Property(x => x.Name).IsRequired().HasColumnName("name").HasColumnType("text");
        }
    }
}
