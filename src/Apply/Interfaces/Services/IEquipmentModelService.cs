using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Wrappers;

namespace TesteEstágioBackendV2.src.Apply.Interfaces.Services
{
    public interface IEquipmentModelService
    {
        Task<Response<List<EquipmentModelDTO>>> GetAllAsync();

        Task<Response<EquipmentModelDTO>> GetByIdAsync(Guid id);

        Task<Response<Guid>> RegisterAsync(EquipmentModelDTO dto);

        Task<Response<Guid>> UpdateAsync(EquipmentModelDTO dto);

        Task<Response<Guid>> RemoveAsync(Guid id);
    }
}