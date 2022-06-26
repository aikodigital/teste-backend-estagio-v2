using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Wrappers;

namespace TesteEstágioBackendV2.src.Apply.Interfaces.Services
{
    public interface IEquipmentStateHistoryService
    {
        Task<Response<List<EquipmentStateHistoryDTO>>> GetAllAsync();

        Task<Response<EquipmentStateHistoryDTO>> GetByIdAsync(Guid id);

        Task<Response<Guid>> RegisterAsync(EquipmentStateHistoryDTO dto);

        Task<Response<Guid>> UpdateAsync(EquipmentStateHistoryDTO dto);

        Task<Response<Guid>> RemoveAsync(Guid id);
    }
}