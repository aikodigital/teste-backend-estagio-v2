using Domain.Dtos.Equipment;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Dtos.Equipments
{
    public class EquipmentDto
    {
        public Guid Id { get; set; }
        public Guid EquipmentModelId { get; set; }
        public EquipmentModelDto EquipmentModel { get; set; }
        public string Name { get; set; }
        public DateTime CreatAt { get; set; }
    }
}
