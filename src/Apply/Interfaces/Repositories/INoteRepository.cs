using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.domain;

namespace TesteEstágioBackendV2.src.Apply.Interfaces.Repositories
{
    public interface INoteRepository :  IGenericRepositoryAsync<Note>
    {
        Task<List<Note>> GetByIdUser(string idUser);
    }
}