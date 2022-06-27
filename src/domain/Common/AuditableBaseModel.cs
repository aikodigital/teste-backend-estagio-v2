using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.domain.Common
{
    public abstract class AuditableBaseModel
    {
         public DateTime Created { get; set; }
         public DateTime? LastModified { get; set; }
    }
}