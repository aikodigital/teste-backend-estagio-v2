using Domain.Template;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Models
{
    public class EquipmentTemplate : BaseTemplate
    {
        private Guid _equipmentModelId;

        public Guid EquipmentModelId
        {
            get { return _equipmentModelId; }
            set { _equipmentModelId = value; }
        }
       
        public virtual EquipmentModelTemplate EquipmentModel { get; set; }


        private string _name;

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }

    }
}
