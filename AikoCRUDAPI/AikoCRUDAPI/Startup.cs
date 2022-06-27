using AikoCRUDAPI.Models;
using AikoCRUDAPI.Repositories;
using Microsoft.EntityFrameworkCore;

namespace AikoCRUDAPI
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        public IConfiguration Configuration { get;}

        public void ConfigureServices(IServiceCollection services)
        {
            var connectionString = Configuration["dbContextSettings:ConnectionStrings"];
            services.AddDbContext<EquipmentContext>(options =>
                options.UseNpgsql(connectionString)
            );
            services.AddMvc(c => c.Conventions.Add(new APIExplorerIgnores()));
            services.AddScoped<IEquipmentsRepos, EquipmentsRepos>();
            services.AddScoped<IEquipmentsModelRepos, EquipmentsModelRepos>();
            services.AddScoped<IEquipmentsStateRepos, EquipmentsStateRepos>();
            services.AddScoped<IEquipmentsStateHistoryRepos, EquipmentsStateHistoryRepos>();
            services.AddScoped<IEquipmentsPositionHistoryRepos, EquipmentsPositionHistoryRepos>();
            services.AddScoped<IEquipmentsModelStateHourlyEarningsRepos, EquipmentsModelStateHourlyEarningsRepos>();
            services.AddControllers();           
            services.AddEndpointsApiExplorer();
            services.AddSwaggerGen();
        }
        public void Configure(WebApplication app, IWebHostEnvironment environment)
        {
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();

            app.UseAuthorization();

            app.MapControllers();
        }
    }
}
