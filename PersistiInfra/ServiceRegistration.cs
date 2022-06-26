using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TesteEstágioBackendV2.src.Apply.Interfaces;

namespace teste-backend-estagio-v2.PersistiInfra
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
                //var connectionString = "User ID=postgres;Password=Zamba,23;Host=localhost;Port=5432;Database=Aiko;Pooling=true;";

                services.AddDbContext<ApplicationDbContext>(options =>
                options.UseNpgsql(connectionString));
            }
            #region Repositories

            services.AddTransient(typeof(IGenericRepositoryAsync<>), typeof(GenericRepositoryAsync<>));
            services.AddTransient<IEquipamentoRepository, EquipamentoRepository>();
            services.AddTransient<IModeloEquipamentoRepository, ModeloEquipamentoRepository>();
            services.AddTransient<IEstadoEquipamentoRepository, EstadoEquipamentoRepository>();
            services.AddTransient<IGanhosHoraEstadoRepository, GanhosHoraEstadoRepository>();

            services.AddTransient<IHistoricoEstadoEquipamentoRepository, HistoricoEstadoEquipamentoRepository>();
            services.AddTransient<IHistoricoPosicaoEquipamentoRepository, HistoricoPosicaoEquipamentoRepository>();

            #endregion
        }
    }
}