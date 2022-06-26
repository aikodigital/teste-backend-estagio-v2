using Microsoft.EntityFrameworkCore;
using equipment_model_state_hourly_earnings.Model;

namespace equipment_model_state_hourly_earnings.Data
{
    public class Equipment_model_state_hourly_earningsContext : DbContext
    {
        public Equipment_model_state_hourly_earningsContext(DbContextOptions<Equipment_model_state_hourly_earningsContext> options) : base(options)
        {
        }
        
        public DbSet<Equipment_model_state_hourly_earnings> Equipment_model_state_hourly_earningss {get;set;}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            var equipment_model_state_hourly_earnings = modelBuilder.Entity<Equipment_model_state_hourly_earnings>();
            equipment_model_state_hourly_earnings.ToTable("tb_equipment_model_state_hourly_earnings");
            equipment_model_state_hourly_earnings.HasKey(x => x.id);
            equipment_model_state_hourly_earnings.Property(x => x.Equipment_model_id).HasColumnName("equipment_model_id").IsRequired();
            equipment_model_state_hourly_earnings.Property(x => x.Equipment_state_id).HasColumnName("equipment_state_id").IsRequired();
            equipment_model_state_hourly_earnings.Property(x => x.Value).HasColumnName("value").IsRequired();
        }
        
    }
}