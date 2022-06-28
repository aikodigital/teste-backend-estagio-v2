using Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Template
{
    public class EquipmentStateTemplate : BaseTemplate
    {
        private string _name;

        public string Name
        {
            get { return _name; }
            set { _name = value; }
        }
        private string _color;

        public string Color
        {
            get { return _color; }
            set { _color = value; }
        }

    }
}
