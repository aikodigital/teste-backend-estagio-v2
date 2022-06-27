using AutoMapper;
using System.Reflection;
using TesteEstágioBackendV2.src.Apply.Behaviours;
using TesteEstágioBackendV2.src.Apply.Features.Services;
using FluentValidation;
using System.Collections;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;
using System.Text;
using MediatR;
using TesteEstágioBackendV2.src.Apply.Interfaces;
using TesteEstágioBackendV2.src.Apply.Interfaces.Services;

namespace TesteEstágioBackendV2.src.Apply
{
    public static class ServiceExtensions
    {
        public static void AddApplicationLayer(this IServiceCollection services)
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
}