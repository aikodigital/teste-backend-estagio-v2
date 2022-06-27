using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.domain;
using TesteEstágioBackendV2.src.PersistiInfra.Contexts;

namespace TesteEstágioBackendV2.src.PersistiInfra.Repositories
{
    public class EquipmentModelRepository : GenericRepositoryAsync<EquipmentModel>
        , IEquipmentModelRepository
    {
        private readonly DbSet<EquipmentModel> equipment;

        public EquipmentModelRepository(ApplicationDbContext dbContext) : base(dbContext)
        {
            equipment = dbContext.Set<EquipmentModel>();
        }
    }
}