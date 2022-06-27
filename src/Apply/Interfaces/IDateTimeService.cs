using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.Apply.Interfaces
{
    public interface IDateTimeService
    {
        DateTime NowUtc { get; }
    }
}