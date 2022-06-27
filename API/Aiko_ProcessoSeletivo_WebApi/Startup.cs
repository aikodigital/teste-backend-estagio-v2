using Aiko_ProcessoSeletivo_WebApi.Contexts;
using Aiko_ProcessoSeletivo_WebApi.Interfaces;
using Aiko_ProcessoSeletivo_WebApi.Repositories;
using Microsoft.EntityFrameworkCore;
using Microsoft.OpenApi.Models;
using Newtonsoft.Json;
using System.Reflection;

namespace Aiko_ProcessoSeletivo_WebApi
{

    // Optei por adicionar o conceito de startup no .net6 visando a organização do codigo
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        public void ConfigureServices(IServiceCollection services)
        {
            services
              .AddControllers()
              .AddNewtonsoftJson(options =>
              {
                  options.SerializerSettings.ReferenceLoopHandling = ReferenceLoopHandling.Ignore;
                  options.SerializerSettings.NullValueHandling = NullValueHandling.Ignore;
              });

            services.AddEndpointsApiExplorer();

            services.AddSwaggerGen();

            services.AddDbContext<EquipamentosContext>(options =>
                options.UseNpgsql(Configuration.GetConnectionString("Default")));


            services.AddTransient<DbContext, EquipamentosContext>();
            services.AddTransient<IEquipmentRepository, EquipmentRepository>();
            services.AddTransient<IEquipmentModelRepository, EquipmentModelRepository>();
            services.AddTransient<IEquipmentStateRepository, EquipmentStateRepository>();
            services.AddTransient<IEquipmentModelStateHourlyEarningRepository, EquipmentModelStateHourlyEarningRepository>();
            services.AddTransient<IEquipmentStateHistoryRepository, EquipmentStateHistoryRepository>();
            services.AddTransient<IEquipmentPositionHistoryRepository, EquipmentPositionHistoryRepository>();


        }

        public void Configure(WebApplication app, IWebHostEnvironment environment)
        {
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI(c => {
                    c.SwaggerEndpoint("/swagger/v1/swagger.json", "Aiko_ProcessoSeletivo.webAPI");
                    c.RoutePrefix = "";
                });
            }

            app.UseRouting();

            app.UseHttpsRedirection();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });
        }
    }
}
