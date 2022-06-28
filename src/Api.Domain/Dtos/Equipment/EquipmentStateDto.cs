using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Dtos.Equipment
{
    public class EquipmentStateDto
    {
        public Guid Id { get; set; }
        public string Name { get; set; }
        public string Color { get; set; }
        public DateTime CreatAt { get; set; }
    }
}
