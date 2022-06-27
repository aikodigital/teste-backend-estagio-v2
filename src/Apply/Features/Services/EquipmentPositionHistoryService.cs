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
    public class EquipmentPositionHistoryService : IEquipmentPositionHistoryService
    {
        private readonly IMapper _mapper;
        private readonly IEquipmentPositionHistoryRepository _equipmentPositionHistoryRepository;
        private ILog logger;

        public EquipmentPositionHistoryService(
            IEquipmentPositionHistoryRepository equipmentPositionHistoryRepository, 
            IMapper mapper, ILog logger)
        {
            _mapper = mapper;
            this._equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
            this.logger = logger;
        }

        public async Task<Response<List<EquipmentPositionHistoryDTO>>> GetAllAsync()
        {
            try
            {
                return new Response<List<EquipmentPositionHistoryDTO>>
               (_mapper.Map<List<EquipmentPositionHistoryDTO>>(
                   await this._equipmentPositionHistoryRepository.GetAllAsync()), $"Lista de equipamentos");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentPositionHistoryDTO>> GetByIdAsync(Guid id)
        {
            try
            {
                return new Response<EquipmentPositionHistoryDTO>
               (_mapper.Map<EquipmentPositionHistoryDTO>(
                   await this._equipmentPositionHistoryRepository.GetByGUIDAsync(id)), 
                   $"Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<Guid>> RegisterAsync(EquipmentPositionHistoryDTO request)
        {
            try
            {
                request.Created = DateTime.Now;
                request.id = Guid.NewGuid();

                var result = _mapper.Map<EquipmentPositionHistory>(request);
                await _equipmentPositionHistoryRepository.AddAsync(result);
                return new Response<Guid>(result.id, Constantes.Constantes.RegistoSalvo);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<Guid>> UpdateAsync(EquipmentPositionHistoryDTO request)
        {
            try
            {
                var result = await _equipmentPositionHistoryRepository.GetByGUIDAsync(request.id);

                if (result != null)
                {
                    result.LastModified = DateTime.Now;
                    await _equipmentPositionHistoryRepository.UpdateAsync(result);
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
                await _equipmentPositionHistoryRepository.DeleteAsync(await this._equipmentPositionHistoryRepository.GetByGUIDAsync(id));
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