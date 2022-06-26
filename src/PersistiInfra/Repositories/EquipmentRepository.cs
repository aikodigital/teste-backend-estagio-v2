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
    public class EquipmentRepository : GenericRepositoryAsync<Equipment>, IEquipmentRepository
    {
         private readonly DbSet<Equipment> equipment;

        public EquipmentRepository(ApplicationDbContext dbContext) : base(dbContext)
        {
            equipment = dbContext.Set<Equipment>();
        }
    }
}