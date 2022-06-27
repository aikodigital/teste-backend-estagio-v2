using Microsoft.EntityFrameworkCore;
namespace AikoCRUDAPI.Models
{
    public class EquipmentContext : DbContext
    {
        public EquipmentContext(DbContextOptions<EquipmentContext> options) : base(options)
        {
        }
        public DbSet<Equipment> equipment { get; set; }
        public DbSet<EquipmentModel> equipment_model { get; set; }
        public DbSet<EquipmentModelStateHourlyEarnings> equipment_model_state_hourly_earnings { get; set; }
        public DbSet<EquipmentPositionHistory> equipment_position_history { get; set; }
        public DbSet<EquipmentState> equipment_state { get; set; }
        public DbSet<EquipmentStateHistory> equipment_state_history { get; set; }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<EquipmentModelStateHourlyEarnings>().HasNoKey();
            modelBuilder.Entity<EquipmentPositionHistory>().HasNoKey();
            modelBuilder.Entity<EquipmentStateHistory>().HasNoKey();
        }
    }
}
