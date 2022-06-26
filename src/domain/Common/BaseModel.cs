using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.domain
{
    public abstract class BaseModel
    {
        public virtual int Id { get; set; }
    }
}