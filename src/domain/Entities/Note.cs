using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.domain
{
    public class Note : BaseModel
    {
        

        //tem que ver este relacionamento
        public string IdUtilizer { get; set; }

        public DateTime DataCriacao { get; set; }

        public string Descricao { get; set; }
    }
}