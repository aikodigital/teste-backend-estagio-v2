using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;
using Aiko_ProcessoSeletivo_WebApi.Domains;

namespace Aiko_ProcessoSeletivo_WebApi.Contexts
{
    public partial class EquipamentosContext : DbContext
    {
        public EquipamentosContext()
        {
        }

        public EquipamentosContext(DbContextOptions<EquipamentosContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Equipment> Equipment { get; set; } = null!;
        public virtual DbSet<EquipmentModel> EquipmentModels { get; set; } = null!;
        public virtual DbSet<EquipmentModelStateHourlyEarning> EquipmentModelStateHourlyEarnings { get; set; } = null!;
        public virtual DbSet<EquipmentPositionHistory> EquipmentPositionHistories { get; set; } = null!;
        public virtual DbSet<EquipmentState> EquipmentStates { get; set; } = null!;
        public virtual DbSet<EquipmentStateHistory> EquipmentStateHistories { get; set; } = null!;

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            { 
                optionsBuilder.UseNpgsql("Host=localhost;Port=5432;Pooling=true;Database=equipamentos;User Id=postgres;Password=Senai@132;");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Equipment>(entity =>
            {
                entity.ToTable("equipment", "operation");

                entity.Property(e => e.Id)
                    .ValueGeneratedNever()
                    .HasColumnName("id");

                entity.Property(e => e.EquipmentModelId).HasColumnName("equipment_model_id");

                entity.Property(e => e.Name).HasColumnName("name");

                entity.HasOne(d => d.EquipmentModel)
                    .WithMany(p => p.Equipment)
                    .HasForeignKey(d => d.EquipmentModelId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("fk_equipment_model");
            });

            modelBuilder.Entity<EquipmentModel>(entity =>
            {
                entity.ToTable("equipment_model", "operation");

                entity.Property(e => e.Id)
                    .ValueGeneratedNever()
                    .HasColumnName("id");

                entity.Property(e => e.Name).HasColumnName("name");
            });

            modelBuilder.Entity<EquipmentModelStateHourlyEarning>(entity =>
            {
               // entity.HasNoKey();

                entity.ToTable("equipment_model_state_hourly_earnings", "operation");

                entity.Property(e => e.EquipmentModelId).HasColumnName("equipment_model_id");

                entity.Property(e => e.EquipmentStateId).HasColumnName("equipment_state_id");

                entity.Property(e => e.Value).HasColumnName("value");

                entity.HasOne(d => d.EquipmentModel)
                    .WithMany()
                    .HasForeignKey(d => d.EquipmentModelId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("fk_equipment_model");

                entity.HasOne(d => d.EquipmentState)
                    .WithMany()
                    .HasForeignKey(d => d.EquipmentStateId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("fk_equipment_state");
            });

            modelBuilder.Entity<EquipmentPositionHistory>(entity =>
            {
                //entity.HasNoKey();

                entity.ToTable("equipment_position_history", "operation");

                entity.Property(e => e.Date)
                    .HasColumnType("timestamp without time zone")
                    .HasColumnName("date");

                entity.Property(e => e.EquipmentId).HasColumnName("equipment_id");

                entity.Property(e => e.Lat).HasColumnName("lat");

                entity.Property(e => e.Lon).HasColumnName("lon");

                entity.HasOne(d => d.Equipment)
                    .WithMany()
                    .HasForeignKey(d => d.EquipmentId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("fk_equipment");
            });

            modelBuilder.Entity<EquipmentState>(entity =>
            {
                entity.ToTable("equipment_state", "operation");

                entity.Property(e => e.Id)
                    .ValueGeneratedNever()
                    .HasColumnName("id");

                entity.Property(e => e.Color).HasColumnName("color");

                entity.Property(e => e.Name).HasColumnName("name");
            });

            modelBuilder.Entity<EquipmentStateHistory>(entity =>
            {
               // entity.HasNoKey();

                entity.ToTable("equipment_state_history", "operation");

                entity.Property(e => e.Date)
                    .HasColumnType("timestamp without time zone")
                    .HasColumnName("date");

                entity.Property(e => e.EquipmentId).HasColumnName("equipment_id");

                entity.Property(e => e.EquipmentStateId).HasColumnName("equipment_state_id");

                entity.HasOne(d => d.Equipment)
                    .WithMany()
                    .HasForeignKey(d => d.EquipmentId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("fk_equipment");

                entity.HasOne(d => d.EquipmentState)
                    .WithMany()
                    .HasForeignKey(d => d.EquipmentStateId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("fk_equipment_state");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
