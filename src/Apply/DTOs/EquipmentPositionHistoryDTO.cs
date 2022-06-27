using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.Apply.DTOs
{
    public class EquipmentPositionHistoryDTO
    {
        public Guid id { get; set; }

        public Guid equipment { get; set; }

        public DateTime date { get; set; }
        public double lat { get; set; }
        public double lon { get; set; }

        public DateTime Created { get; set; }
        public DateTime? LastModified { get; set; }
    }
}