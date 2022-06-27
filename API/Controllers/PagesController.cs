using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace TesteEstágioBackendV2.Controllers
{

    [Route("dashboard")]
    [ApiExplorerSettings(IgnoreApi = true)]
    public class PagesController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}