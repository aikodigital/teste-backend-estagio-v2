using Equipments.Models;
using Microsoft.EntityFrameworkCore;


namespace Equipments.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> opt) : base(opt)
        {

        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<Equipment>()
                .HasOne(equipment => equipment.equipment_model)
                .WithMany(equipment_model => equipment_model.equipments)
                .HasForeignKey(equipment => equipment.equipment_model_id);

            builder.Entity<Equipment_Model_State_Hourly_Earnings>()
                .HasKey(e => new {e.equipment_model_id, e.equipment_state_id});

            builder.Entity<Equipment_Model_State_Hourly_Earnings>()
            .HasOne(hourlyEarnings => hourlyEarnings.equipment_model)
            .WithMany(equipment_model => equipment_model.hourlyEarnings)
            .HasForeignKey(hourlyEarnings => hourlyEarnings.equipment_model_id)
            ;

            builder.Entity<Equipment_Model_State_Hourly_Earnings>()
            .HasOne(hourlyEarnings => hourlyEarnings.equipment_state)
            .WithMany(equipment_state => equipment_state.hourlyEarnings)
            .HasForeignKey(hourlyEarnings => hourlyEarnings.equipment_state_id)
            ;

            builder.Entity<Equipment_Position_History>()
                .HasKey(e => new { e.equipment_id, e.date });

            builder.Entity<Equipment_State_History>()
                .HasKey(e => new { e.equipment_id, e.date });

            builder.Entity<Equipment_State_History>()
            .HasOne(equipmentStateHistories => equipmentStateHistories.equipment_state)
            .WithMany(equipment_state => equipment_state.equipmentStateHistories)
            .HasForeignKey(equipmentStateHistories => equipmentStateHistories.equipment_state_id)
            ;

            builder.Entity<Equipment_State_History>()
            .HasOne(equipmentStateHistories => equipmentStateHistories.equipment)
            .WithMany(equipment => equipment.equipmentStateHistories)
            .HasForeignKey(equipmentStateHistories => equipmentStateHistories.equipment_id)
            ;

        }

        public DbSet<Equipment_Model> equipment_model { get; set; }
        public DbSet<Equipment> equipment { get; set; }
        public DbSet<Equipment_Model_State_Hourly_Earnings> equipment_model_state_hourly_earnings { get; set; }
        public DbSet<Equipment_Position_History> equipment_position_history { get; set; }
        public DbSet<Equipment_State> equipment_state { get; set; }
        public DbSet<Equipment_State_History> equipment_state_history { get; set; }



    }
}
