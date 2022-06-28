using Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Template
{
    public class EquipmentModelTemplate : BaseTemplate
    {

        private string _name;

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }
    }
}
