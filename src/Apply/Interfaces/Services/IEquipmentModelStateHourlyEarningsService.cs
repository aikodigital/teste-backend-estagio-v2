using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Wrappers;

namespace TesteEstágioBackendV2.src.Apply.Interfaces.Services
{
    public interface IEquipmentModelStateHourlyEarningsService
    {
        Task<Response<List<EquipmentModelStateHourlyEarningsDTO>>> GetAllAsync();

        Task<Response<EquipmentModelStateHourlyEarningsDTO>> GetByIdAsync(Guid id);

        Task<Response<Guid>> RegisterAsync(EquipmentModelStateHourlyEarningsDTO dto);

        Task<Response<Guid>> UpdateAsync(EquipmentModelStateHourlyEarningsDTO dto);

        Task<Response<Guid>> RemoveAsync(Guid id);
    }
}