using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.Interfaces;

namespace TesteEstágioBackendV2.PublicarInfra.Services
{
    public class DateTimeService : IDateTimeService
    {
                public DateTime NowUtc => DateTime.UtcNow;

    }
}