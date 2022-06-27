using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Wrappers;

namespace TesteEstágioBackendV2.src.Apply.Interfaces.Services
{
    public interface IEquipmentPositionHistoryService
    {
        Task<Response<List<EquipmentPositionHistoryDTO>>> GetAllAsync();

        Task<Response<EquipmentPositionHistoryDTO>> GetByIdAsync(Guid id);

        Task<Response<Guid>> RegisterAsync(EquipmentPositionHistoryDTO dto);

        Task<Response<Guid>> UpdateAsync(EquipmentPositionHistoryDTO dto);

        Task<Response<Guid>> RemoveAsync(Guid id);
    }
}