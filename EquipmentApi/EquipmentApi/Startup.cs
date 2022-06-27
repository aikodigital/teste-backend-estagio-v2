using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using Microsoft.OpenApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Npgsql;
using Microsoft.EntityFrameworkCore;
using EquipmentApi.Data.Interfaces;
using EquipmentApi.Data.Repositories;
using EquipmentApi.Entities;

namespace EquipmentApi
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddDbContext<EquipmentDbContext>(options => options.UseNpgsql(Configuration.GetConnectionString("Default")));

            services.AddScoped(typeof(IBaseRepository<>), typeof(BaseRepository<>));
            services.AddScoped<IBaseRepository<Equipment>, BaseRepository<Equipment>>();
            services.AddScoped<IEquipmentRepository, EquipmentRepository>();
            services.AddScoped<IEquipmentStateRepository, EquipmentStateRepository>();
            services.AddScoped<IEquipmentStateHistoryRepository, EquipmentStateHistoryRepository>();
            services.AddScoped<IEquipmentPositionHistoryRepository, EquipmentPositionHistoryRepository>();
            services.AddScoped<IEquipmentStateRepository, EquipmentStateRepository>();
            services.AddScoped<IEquipmentModelRepository, EquipmentModelRepository>();
            services.AddScoped<IEquipmentModelStateHourlyEarningRepository, EquipmentModelStateHourlyEarningRepository>();
            services.AddAutoMapper(AppDomain.CurrentDomain.GetAssemblies());


            services.AddControllers();
            services.AddControllers().AddNewtonsoftJson(opt => opt.SerializerSettings.ReferenceLoopHandling = Newtonsoft.Json.ReferenceLoopHandling.Ignore);
            services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new OpenApiInfo { Title = "EquipmentApi", Version = "v1" });
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSwagger();
                app.UseSwaggerUI(c => c.SwaggerEndpoint("/swagger/v1/swagger.json", "EquipmentApi v1"));
            }

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });
        }
    }
}
