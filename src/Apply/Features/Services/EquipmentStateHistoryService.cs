using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AutoMapper;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Exceptions;
using TesteEstágioBackendV2.src.Apply.Interfaces.NLog;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.Apply.Interfaces.Services;
using TesteEstágioBackendV2.src.Apply.Wrappers;
using TesteEstágioBackendV2.src.domain;

namespace TesteEstágioBackendV2.src.Apply.Features.Services
{
    public class EquipmentStateHistoryService : IEquipmentStateHistoryService
    {
        private readonly IMapper _mapper;
        private readonly IEquipmentStateHistoryRepository _equipmentStateHistoryRepository;
        private ILog logger;

        public EquipmentStateHistoryService(
            IEquipmentStateHistoryRepository equipmentStateHistoryRepository, 
            IMapper mapper, ILog logger)
        {
            _mapper = mapper;
            this._equipmentStateHistoryRepository = equipmentStateHistoryRepository;
            this.logger = logger;
        }

        public async Task<Response<List<EquipmentStateHistoryDTO>>> GetAllAsync()
        {
            try
            {
                return new Response<List<EquipmentStateHistoryDTO>>
               (_mapper.Map<List<EquipmentStateHistoryDTO>>(
                   await this._equipmentStateHistoryRepository.GetAllAsync()), $"Lista de equipamentos");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentStateHistoryDTO>> GetByIdAsync(Guid id)
        {
            try
            {
                return new Response<EquipmentStateHistoryDTO>
               (_mapper.Map<EquipmentStateHistoryDTO>(
                   await this._equipmentStateHistoryRepository.GetByGUIDAsync(id)), $"Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<Guid>> RegisterAsync(EquipmentStateHistoryDTO request)
        {
            try
            {
                request.Created = DateTime.Now;
                request.id = Guid.NewGuid();

                var result = _mapper.Map<EquipmentStateHistory>(request);
                await _equipmentStateHistoryRepository.AddAsync(result);
                return new Response<Guid>(result.id, Constantes.Constantes.RegistoSalvo);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<Guid>> UpdateAsync(EquipmentStateHistoryDTO request)
        {
            try
            {
                var result = await _equipmentStateHistoryRepository.GetByGUIDAsync(request.id);

                if (result != null)
                {
                    result.LastModified = DateTime.Now;
                    await _equipmentStateHistoryRepository.UpdateAsync(result);
                    return new Response<Guid>(result.id, Constantes.Constantes.RegistoActualizado);
                }
                return new Response<Guid>(Guid.NewGuid(), Constantes.Constantes.ErrorMsg);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<Guid>> RemoveAsync(Guid id)
        {
            try
            {
                await _equipmentStateHistoryRepository.DeleteAsync(
                    await this._equipmentStateHistoryRepository.GetByGUIDAsync(id));
                return new Response<Guid>(id, Constantes.Constantes.RegistoEliminado);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }
    }
}