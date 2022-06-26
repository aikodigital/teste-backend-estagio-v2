using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TesteEstágioBackendV2.src.Apply.Interfaces;
using TesteEstágioBackendV2.src.domain;
using TesteEstágioBackendV2.src.domain.Common;

namespace TesteEstágioBackendV2.src.PersistiInfra.Contexts
{
    public class ApplicationDbContext : DbContext
    {
                private readonly IDateTimeService _dateTime;

        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options, 
            IDateTimeService dateTime) : base(options)
        {
            ChangeTracker.QueryTrackingBehavior = QueryTrackingBehavior.NoTracking;
            _dateTime = dateTime;
        }


        public DbSet<Note> Notes { get; set; }
        public DbSet<Equipment> Equipments { get; set; }
        public DbSet<EquipmentModel> EquipmentModels { get; set; }
        public DbSet<EquipmentModelStateHourlyEarnings> EquipmentModelStateHourlyEarnings { get; set; }
        public DbSet<EquipmentPositionHistory> EquipmentPositionHistory { get; set; }
        public DbSet<EquipmentState> EquipmentState { get; set; }
        public DbSet<EquipmentStateHistory> EquipmentStateHistory { get; set; }

        public override Task<int> SaveChangesAsync(CancellationToken cancellationToken = new CancellationToken())
        {
            foreach (var entry in ChangeTracker.Entries<AuditableBaseModel>())
            {
                switch (entry.State)
                {
                    case EntityState.Added:
                        entry.Entity.Created = _dateTime.NowUtc;
                        break;
                    case EntityState.Modified:
                        entry.Entity.LastModified = _dateTime.NowUtc;
                        break;
                }
            }
            return base.SaveChangesAsync(cancellationToken);
        }
        protected override void OnModelCreating(ModelBuilder builder)
        {
            //All Decimals will have 18,6 Range
            foreach (var property in builder.Model.GetEntityTypes()
            .SelectMany(t => t.GetProperties())
            .Where(p => p.ClrType == typeof(decimal) || p.ClrType == typeof(decimal?)))
            {
                property.SetColumnType("decimal(18,6)");
            }

            builder.Entity<EquipmentState>().HasData(
                    new EquipmentState { id=1, name = "Operando" },
                    new EquipmentState { id = 2, name = "Parado" },
                    new EquipmentState { id = 3, name = "Manutenção" }
                );

            base.OnModelCreating(builder);
        }
    }
}