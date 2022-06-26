using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.Exceptions;
using TesteEstágioBackendV2.src.Apply.Interfaces;

namespace TesteEstágioBackendV2.PublicarInfra.Services
{
    public class FileService : IFileService
    {
        public ILogger<FileService> _logger { get; }


        public FileService(ILogger<FileService> logger)
        {
            _logger = logger;
        }

        public async Task<bool> CriarPasta(String nomePasta)
        {
            try
            {
                Directory.CreateDirectory(nomePasta);
                return await Task.FromResult(true);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Ocorreu uma expção: " + ex.Message);
                return await Task.FromResult(false);
            }
        }

        public async Task<bool> ConterBase64TOimage(string filePath, string content)
        {
            try
            {
                if (await EnsureFolder(filePath))
                {
                    var base64Data = Regex.Match(content, @"data:image/(?<type>.+?),(?<data>.+)").Groups["data"].Value;
                    var bytes = Convert.FromBase64String(base64Data);
                    using (var imageFile = new FileStream(filePath, FileMode.Create))
                    {
                        BinaryWriter writer = new BinaryWriter(imageFile);
                        imageFile.Write(bytes, 0, bytes.Length);
                        //imageFile.Flush();
                    }

                    return await Task.FromResult(true);

                }

                return await Task.FromResult(false);
            }
            catch (System.Exception ex)
            {
                _logger.LogError(ex.Message, ex);
                throw new ApiException(ex.Message);
            }
        }

        private async Task<bool> EnsureFolder(string path)
        {
            try
            {
                string directoryName = Path.GetDirectoryName(path);
                // If path is a file name only, directory name will be an empty string
                if (directoryName.Length > 0)
                {
                    // Create all directories on the path that don't already exist
                    Directory.CreateDirectory(directoryName);
                }

                return await Task.FromResult(true);
            }
            catch (System.Exception ex)
            {
                _logger.LogError(ex.Message, ex);
                throw new ApiException(ex.Message);
            }

        }

   


        public async Task<bool> ConterBase64TOFile(string filePath, string content)
        {
            try
            {
                byte[] imgByteArray = Convert.FromBase64String(content);

                File.WriteAllBytes(filePath, imgByteArray);

                return await Task.FromResult(true);
            }
            catch (Exception ex)
            {
                throw new ApiException(ex.Message);
              
            }
        }
        
    }
}