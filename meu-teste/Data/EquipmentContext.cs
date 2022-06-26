using Microsoft.EntityFrameworkCore;
using equipment.Model;

namespace equipment.Data
{
    public class EquipmentContext : DbContext
    {
        public EquipmentContext(DbContextOptions<EquipmentContext> options) : base(options)
        {
        }
        
        public DbSet<Equipment> Equipments {get;set;}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            var equipment = modelBuilder.Entity<Equipment>();
            equipment.ToTable("c_equipment");
            equipment.HasKey(x => x.Id);
            equipment.Property(x => x.Id).HasColumnName("id").ValueGeneratedOnAdd();
            equipment.Property(x => x.Equipment_model_id).HasColumnName("equipment_model_id").IsRequired();
            equipment.Property(x => x.Name).HasColumnName("name");
        }
        
    }
}