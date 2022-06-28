using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Models
{
    public abstract class BaseTemplate
    {
        private Guid _id;

        public Guid Id
        {
            get { return _id; }
            set { _id = value; }
        }
        
        private DateTime? _createAt;
        public DateTime? CreateAt
        {
            get { return _createAt; }
            set { _createAt = (value == null ? DateTime.UtcNow : value); }
        }
        public DateTime? UpdateAt { get; set; }
    }
}
