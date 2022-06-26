using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.domain;
using TesteEstágioBackendV2.src.PersistiInfra.Repositories;

namespace TesteEstágioBackendV2.src.PersistiInfra.Repositories
{
    public class EquipmentStateRepository : GenericRepositoryAsync<EquipmentState>,
        IEquipmentStateRepository
    {
        private readonly DbSet<EquipmentState> equipment_state;

        public  EquipmentStateRepository(ApplicationDbContext dbContext) : base(dbContext)
        {
            equipment_state = dbContext.Set<EquipmentState>();
        }
    }
}