using Domain.Interfaces.Services;
using Domain.Interfaces.Services.User;
using Microsoft.Extensions.DependencyInjection;
using Service.Services;
using System;
using System.Collections.Generic;
using System.Text;

namespace CrossCutting.DependencyInjection
{
    public class ConfigureService
    {
        public static void ConfigureDependenciesService (IServiceCollection serviceCollection)
        {
            serviceCollection.AddTransient<IEquipmentService, EquipmentService>();
            serviceCollection.AddTransient<IEquipmentModelService, EquipmentModelService>();
            serviceCollection.AddTransient<IEquipmentStateService, EquipmentStateService>();
            serviceCollection.AddTransient<IEquipmentModelStateHourlyEarningsService, EquipmentModelStateHourlyEarningsService>();
            serviceCollection.AddTransient<IEquipmentStateHistoryService, EquipmentStateHistoryService>();
            serviceCollection.AddTransient<IEquipmentPositionHistoryService, EquipmentPositionHistoryService>();
        }
    }
}
