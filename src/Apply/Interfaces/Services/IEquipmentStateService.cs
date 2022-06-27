using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Wrappers;

namespace TesteEstágioBackendV2.src.Apply.Interfaces.Services
{
    public interface IEquipmentStateService
    {
        Task<Response<List<EquipmentStateDTO>>> GetAllAsync();

        Task<Response<EquipmentStateDTO>> GetByIdAsync(int id);

        Task<Response<int>> RegisterAsync(EquipmentStateDTO dto);

        Task<Response<int>> UpdateAsync(EquipmentStateDTO dto);

        Task<Response<int>> RemoveAsync(int id);
    }
}