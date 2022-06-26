using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Interfaces.Services;
using TesteEstágioBackendV2.src.Apply.Wrappers;

namespace TesteEstágioBackendV2.src.Apply.Interfaces
{
    public interface IEquipmentService
    {
        Task<Response<List<EquipmentDTO>>> GetAllAsync();

        Task<Response<EquipmentDTO>> GetByIdAsync(Guid id);

        Task<Response<Guid>> RegisterAsync(EquipmentDTO dto);

        Task<Response<Guid>> UpdateAsync(EquipmentDTO dto);

        Task<Response<Guid>> RemoveAsync(Guid id);

        Task<Response<EquipmentPositionHistoryDTO>> GetPosicaoAtualById(Guid id);

        Task<Response<EquipmentStateHistoryDTO>> GetEstadoAtualById(Guid id);

        Task<Response<int>> GetGanhoByEquipamentoById(Guid id);

        Task<Response<string>> GetProdutividadeByEquipamentoById(Guid id);
    }
}