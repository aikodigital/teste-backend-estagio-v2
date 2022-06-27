using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.Apply.DTOs
{
    public class EquipmentStateHistoryDTO
    {
        public Guid id { get; set; }
        public Guid equipment { get; set; }

        public DateTime date { get; set; }

        public int equipmentState { get; set; }

        public DateTime Created { get; set; }
        public DateTime? LastModified { get; set; }
    }
}