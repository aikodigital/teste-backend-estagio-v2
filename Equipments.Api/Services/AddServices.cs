using Equipments.Domain.Handler;
using Equipments.Domain.Repositories;
using Equipments.Infra.Context;
using Equipments.Infra.Repositories;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Api.Services
{
    public static class AddServices
    {
        public static void Services(IServiceCollection service)
        {
            service.AddControllers();

            service.AddTransient<Handler, Handler>();

            service.AddTransient<IEquipmentRepository, EquipmentRepository>();
            service.AddTransient<IEquipmentModelRepository, EquipmentModelRepository>();
            service.AddTransient<IEquipmentStateRepository, EquipmentStateRepository>();
            service.AddTransient<IEquipmentStateHistoryRepository, EquipmentStateHistoryRepository>();
            service.AddTransient<IEquipmentPositionHistoryRepository, EquipmentPositionHistoryRepository>();
            service.AddTransient<IEquipmentHourlyEarningsRepository, EquipmentHourlyEarningsRepository>();
        }
    }
}
