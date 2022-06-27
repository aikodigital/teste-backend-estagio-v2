using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.Apply.DTOs
{
    public class EquipmentModelStateHourlyEarningsDTO
    {
        public Guid id { get; set; }

        public Guid equipmentModel { get; set; }

        public int equipmentState { get; set; }

        public double value { get; set; }

        public DateTime Created { get; set; }
        public DateTime? LastModified { get; set; }
    }
}