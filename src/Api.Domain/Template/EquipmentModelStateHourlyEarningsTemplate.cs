using Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Template
{
    public class EquipmentModelStateHourlyEarningsTemplate : BaseTemplate
    {
        private decimal _value;

        public decimal Value
        {
            get { return _value; }
            set { _value = value; }
        }

        public Guid EquipmentModelId { get; set; }
        public virtual EquipmentModelTemplate EquipmentModel { get; set; }
        public Guid EquipmentStateId { get; set; }
        public virtual EquipmentStateTemplate EquipmentState { get; set; }
    }
}
