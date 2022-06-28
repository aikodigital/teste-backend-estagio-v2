using Domain.Dtos.Equipments;
using Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Template
{
    public class EquipmentStateHistoryTemplate : BaseTemplate
    {
        private DateTime _date;

        public DateTime Date
        {
            get { return _date; }
            set { _date = value; }
        }
        public Guid EquipmentId { get; set; }
        public virtual EquipmentTemplate Equipment { get; set; }
        public Guid EquipmentStateId { get; set; }
        public virtual EquipmentStateTemplate EquipmentState { get; set; }
    }
}
