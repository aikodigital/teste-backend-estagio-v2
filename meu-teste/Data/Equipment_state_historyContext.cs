using Microsoft.EntityFrameworkCore;
using equipment_state_history.Model;

namespace equipment_state_history.Data
{
    public class Equipment_state_historyContext : DbContext
    {
        public Equipment_state_historyContext(DbContextOptions<Equipment_state_historyContext> options) : base(options)
        {
        }
        
        public DbSet<Equipment_state_history> Equipment_state_historys {get;set;}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            var equipment_state_history = modelBuilder.Entity<Equipment_state_history>();
            equipment_state_history.ToTable("tb_equipment_state_history");
            equipment_state_history.HasNoKey();
            equipment_state_history.Property(x => x.Equipment_id).HasColumnName("equipment_id").IsRequired();
            equipment_state_history.Property(x => x.Date).HasColumnName("date");
            equipment_state_history.Property(x => x.Equipment_state_id).HasColumnName("equipment_state_id").IsRequired();
        }
        
    }
}