using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;
using System.Text;
using TesteEstágioBackendV2.src.Apply.Interfaces;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.PersistiInfra.Contexts;
using TesteEstágioBackendV2.src.PersistiInfra.Repositories;

namespace TesteEstágioBackendV2.PersistiInfra
{
    public static class ServiceRegistration
    {
        public static void AddPersistenceInfrastructure(this IServiceCollection services, IConfiguration configuration)
        {
            if (configuration.GetValue<bool>("UseInMemoryDatabase"))
            {
                services.AddDbContext<ApplicationDbContext>(options =>
                    options.UseInMemoryDatabase("CleanArq"));
            }
            else
            {
                var connectionString = Environment.GetEnvironmentVariable("DB_CONNECTION_STRING");
                //var connectionString = "User ID=postgres;Password=dodo2022,23;Host=localhost;Port=5432;Database=Aiko_Equipment;Pooling=true;";

                services.AddDbContext<ApplicationDbContext>(options =>
                options.UseNpgsql(connectionString));
            }
            #region Repositories

            services.AddTransient(typeof(IGenericRepositoryAsync<>), typeof(GenericRepositoryAsync<>));
            services.AddTransient<IEquipmentRepository, EquipmentRepository>();
            services.AddTransient<IEquipmentModelRepository, EquipmentModelRepository>();
            services.AddTransient<IEquipmentStateRepository, EquipmentStateRepository>();
            services.AddTransient<IEquipmentModelStateHourlyEarningsRepository, EquipmentModelStateHourlyEarningsRepository>();

            services.AddTransient<IEquipmentStateHistoryRepository, EquipmentStateHistoryRepository>();
            services.AddTransient<IEquipmentPositionHistoryRepository, EquipmentPositionHistoryRepository>();

            #endregion
        }
    }
}