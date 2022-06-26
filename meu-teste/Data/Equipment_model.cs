using Microsoft.EntityFrameworkCore;
using equipment_model.Model;

namespace equipment_model.Data
{
    public class Equipment_modelContext : DbContext
    {
        public Equipment_modelContext(DbContextOptions<Equipment_modelContext> options) : base(options)
        {
        }
        
        public DbSet<Equipment_model> Equipment_models {get;set;}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            var equipment_model = modelBuilder.Entity<Equipment_model>();
            equipment_model.ToTable("equipment_model");
            equipment_model.HasKey(x => x.Id);
            equipment_model.Property(x => x.Id).HasColumnName("id").ValueGeneratedOnAdd();
            equipment_model.Property(x => x.Name).HasColumnName("name").IsRequired();
        }
        
    }
}