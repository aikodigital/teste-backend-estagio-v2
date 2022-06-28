using Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Template
{
    public class EquipmentPositionHistoryTemplate : BaseTemplate
    {
        private string _date;

        public string Date
        {
            get { return _date; }
            set { _date = value; }
        }
        private float _lat;

        public float Lat
        {
            get { return _lat; }
            set { _lat = value; }
        }
        private float _lon;

        public float Lon
        {
            get { return _lon; }
            set { _lon = value; }
        }        

        public Guid EquipmentId { get; set; }
        public virtual EquipmentTemplate Equipment { get; set; }
    }
}
