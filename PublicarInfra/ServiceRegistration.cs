using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.PublicarInfra.Services;
using TesteEstágioBackendV2.src.Apply.Interfaces;
using TesteEstágioBackendV2.src.domain.Settings;

namespace TesteEstágioBackendV2.PublicarInfra
{
    public static class ServiceRegistration 
    {

        public static void AddSharedInfrastructure(this IServiceCollection services, IConfiguration _config)
        {
            services.Configure<MailSettings>(_config.GetSection("MailSettings"));
            services.AddTransient<IDateTimeService, DateTimeService>();
            services.AddTransient<IEmailService, EmailService>();
            services.AddTransient<IFileService, FileService>();
        }
    }
}