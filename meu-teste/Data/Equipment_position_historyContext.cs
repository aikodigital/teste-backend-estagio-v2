using Microsoft.EntityFrameworkCore;
using equipment_position_history.Model;

namespace equipment_position_history.Data
{
    public class Equipment_position_historyContext : DbContext
    {
        public Equipment_position_historyContext(DbContextOptions<Equipment_position_historyContext> options) : base(options)
        {
        }
        
        public DbSet<Equipment_position_history> Equipment_position_historys {get;set;}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            var equipment_position_history = modelBuilder.Entity<Equipment_position_history>();
            equipment_position_history.ToTable("equipment_position_history");
            equipment_position_history.HasKey(x => x.id);
            equipment_position_history.Property(x => x.Equipment_id).HasColumnName("equipment_id").IsRequired();
            equipment_position_history.Property(x => x.Date).HasColumnName("date");
            equipment_position_history.Property(x => x.Lat).HasColumnName("lat").IsRequired();
            equipment_position_history.Property(x => x.Lon).HasColumnName("lon").IsRequired();
        }
        
    }
}