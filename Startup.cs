
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using NLog;
using System.IO;
using TesteEstágioBackendV2.PublicarInfra.Services;
using TesteEstágioBackendV2.src.Apply.Interfaces.NLog;
using WebApi.Extensions;

namespace WebApi
{
    public class Startup
    {
        public IConfiguration _config { get; }
        public Startup(IConfiguration configuration)
        {
            _config = configuration;
        }
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddCors();
            services.AddApplicationLayer();
			services.AddPersistenceInfrastructure(_config);
			services.AddSharedInfrastructure(_config);
			services.AddSwaggerExtension();
			services.AddControllers();
            services.AddApiVersioningExtension();
			services.AddHealthChecks();
            services.AddRazorPages();
            var appBasePath = System.IO.Directory.GetCurrentDirectory();
            NLog.GlobalDiagnosticsContext.Set("appbasepath", appBasePath);
            LogManager.LoadConfiguration(System.String.Concat(Directory.GetCurrentDirectory(), "/Nlog.config"));
            services.AddSingleton<ILog, LogNLog>();
            // register PeerJs Server dependencies
            services.AddSignalR();

        }

        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
			}
			else
			{
				app.UseExceptionHandler("/Error");
				app.UseHsts();
			}

            app.UseCors(x => x
                .AllowAnyMethod()
                .AllowAnyHeader()
                .SetIsOriginAllowed(origin => true) // allow any origin
                .AllowCredentials()); // allow credentials
            //app.UseHttpsRedirection();
            app.UseRouting();
            app.UseAuthentication();
            app.UseAuthorization();
			app.UseSwaggerExtension();
			app.UseErrorHandlingMiddleware();
			app.UseHealthChecks("/health");

			app.UseEndpoints(endpoints =>
            {
                endpoints.MapRazorPages();
                endpoints.MapControllers();
            });
        }
    }
}
