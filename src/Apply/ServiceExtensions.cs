using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.Apply
{
    public static class ServiceExtensions
    {
        services.AddAutoMapper(Assembly.GetExecutingAssembly());
            services.AddValidatorsFromAssembly(Assembly.GetExecutingAssembly());
            services.AddMediatR(Assembly.GetExecutingAssembly());
            services.AddTransient(typeof(IPipelineBehavior<,>), typeof(ValidationBehavior<,>));

            services.AddTransient<IEquipmentService, EquipmentService>();
            services.AddTransient<IEquipmentModelService, EquipmentModelService>();
            services.AddTransient<IEquipmentStateService, EquipmentStateService>();
            services.AddTransient<IEquipmentModelStateHourlyEarningsService, EquipmentModelStateHourlyEarningsService>();
            services.AddTransient<IEquipmentStateHistoryService, EquipmentStateHistoryService>();
            services.AddTransient<IEquipmentPositionHistoryService, EquipmentPositionHistoryService>();
    }
}