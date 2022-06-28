using Api.Domain.Interfaces;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;
using System.Text;
using Data.Repository;
using Microsoft.EntityFrameworkCore;
using Api.Data.Context;
using Domain.Repository;
using Pomelo.EntityFrameworkCore.MySql.Infrastructure;

namespace CrossCutting.DependencyInjection
{
    public class ConfigureRepository
    {
        public static void ConfigureDependenciesRepository (IServiceCollection serviceCollection)
        {
            serviceCollection.AddScoped(typeof(IRepository<>), typeof (BaseRepository<>));
            serviceCollection.AddScoped<IEquipmentRepository, EquipmentRepository>();
            serviceCollection.AddScoped<IEquipmentModelRepository, EquipmentModelRepository>();
            serviceCollection.AddScoped<IEquipmentStateRepository, EquipmentStateRepository>();
            serviceCollection.AddScoped<IEquipmentModelStateHourlyEarningsRepository, EquipmentModelStateHourlyEarningsRepository>();
            serviceCollection.AddScoped<IEquipmentStateHistoryRepository, EquipmentStateHistoryRepository>();
            serviceCollection.AddScoped<IEquipmentPositionHistoryRepository, EquipmentPositionHistoryRepository>();


            serviceCollection.AddDbContext<MyContext>(
        //options => options.UseMySql(Environment.GetEnvironmentVariable("DB_CONNECTION"),
        //    new MySqlServerVersion(new Version(8, 0, 21)),
        //        mySqlOptions => mySqlOptions
        //            .CharSetBehavior(CharSetBehavior.NeverAppend))
            options => options.UseNpgsql("Server=localhost;Port=5432;Database=Aiko;UserId=postgres;Password=mudar@123")
    );
        }
    }
}
