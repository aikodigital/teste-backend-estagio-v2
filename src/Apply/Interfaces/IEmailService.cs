using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.DTOs.Emails;

namespace TesteEstágioBackendV2.src.Apply.Interfaces
{
    public interface IEmailService
    {
        Task SendAsync(EmailRequest request);
    }
}