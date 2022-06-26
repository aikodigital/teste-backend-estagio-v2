using Microsoft.EntityFrameworkCore;
using equipment_state.Model;

namespace equipment_state.Data
{
    public class Equipment_stateContext : DbContext
    {
        public Equipment_stateContext(DbContextOptions<Equipment_stateContext> options) : base(options)
        {
        }
        
        public DbSet<Equipment_state> Equipment_states {get;set;}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            var equipment_state = modelBuilder.Entity<Equipment_state>();
            equipment_state.ToTable("c_equipment_state");
            equipment_state.HasKey(x => x.Id);
            equipment_state.Property(x => x.Id).HasColumnName("id").ValueGeneratedOnAdd();
            equipment_state.Property(x => x.Name).HasColumnName("name").IsRequired();
            equipment_state.Property(x => x.Color).HasColumnName("color").IsRequired();
        }
        
    }
}