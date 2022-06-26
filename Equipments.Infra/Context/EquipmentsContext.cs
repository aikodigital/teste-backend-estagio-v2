using Equipments.Domain.Entities;
using Equipments.Infra.Context.Mappings;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Infra.Context
{
    public class EquipmentsContext : DbContext
    {
        public DbSet<Equipment> Equipments { get; set; }
        public DbSet<EquipmentModel> EquipmentModel { get; set; }
        public DbSet<EquipmentState> EquipmentState { get; set; }
        public DbSet<EquipmentPositionHistory> EquipmentPositionHistory { get; set; }
        public DbSet<EquipmentHourlyEarnings> EquipmentHourlyEarnings{ get; set; }
        public DbSet<EquipmentStateHistory> EquipmentStateHistory { get; set; }

        public EquipmentsContext(DbContextOptions options) : base(options)
        {

        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Equipment>().ToTable("equipment");
            modelBuilder.ApplyConfiguration(new EquipmentMap());
            modelBuilder.ApplyConfiguration(new EquipmentHourlyEarningsMap());
            modelBuilder.ApplyConfiguration(new EquipmentModelMap());
            modelBuilder.ApplyConfiguration(new EquipmentStateMap());
            modelBuilder.ApplyConfiguration(new EquipmentPositionHistoryMap());
            modelBuilder.ApplyConfiguration(new EquipmentStateHistoryMap());
        }
    }
}
