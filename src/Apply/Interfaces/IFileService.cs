using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.Apply.Interfaces
{
    public interface IFileService
    {
        Task<bool> CriarPasta(String nomePasta);

        Task<bool> ConterBase64TOimage(string filePath, string content);


        Task<bool> ConterBase64TOFile(string filePath, string content);
    }
}