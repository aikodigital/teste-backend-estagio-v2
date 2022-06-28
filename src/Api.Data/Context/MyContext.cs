using Api.Domain.Entities;
using Data.Mapping;
using Domain.Entities;
using Microsoft.EntityFrameworkCore;

namespace Api.Data.Context
{
    public class MyContext: DbContext
    {
        //public DbSet<UserEntity> Users { get; set; }
        public DbSet<EquipmentModelEntity> EquipmentModel { get; set; }
        public DbSet<EquipmentStateEntity> EquipmentState { get; set; }
        public DbSet<EquipmentEntity> Equipment { get; set; }
        public DbSet<EquipmentModelStateHourlyEarningsEntity> EquipmentModelStateHourlyEarnings { get; set; }
        public DbSet<EquipmentStateHistoryEntity> EquipmentStateHistory { get; set; }
        public DbSet<EquipmentPositionHistoryEntity> EquipmentPositionHistory { get; set; }

        public MyContext (DbContextOptions<MyContext> options) : base (options){ }

        protected override void OnModelCreating (ModelBuilder modelBuilder){
            base.OnModelCreating (modelBuilder);
            //modelBuilder.Entity<UserEntity> (new UserMap().Configure);
            modelBuilder.Entity<EquipmentModelEntity>(new EquipmentModelMap().Configure);
            modelBuilder.Entity<EquipmentStateEntity>(new EquipmentStateMap().Configure);
            modelBuilder.Entity<EquipmentEntity>(new EquipmentMap().Configure);
            modelBuilder.Entity<EquipmentModelStateHourlyEarningsEntity>(new EquipmentModelStateHourlyEarningsMap().Configure);
            modelBuilder.Entity<EquipmentStateHistoryEntity>(new EquipmentStateHistoryMap().Configure);
            modelBuilder.Entity<EquipmentPositionHistoryEntity>(new EquipmentPositionHistoryMap().Configure);

        }
    }
}
