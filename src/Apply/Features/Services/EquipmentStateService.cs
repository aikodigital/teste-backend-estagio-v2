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
    public class EquipmentStateService : IEquipmentStateService
    {
        private readonly IMapper _mapper;
        private readonly IEquipmentStateRepository _equipmentStateRepository;
        private ILog logger;

        public EquipmentStateService(
            IEquipmentStateRepository equipmentStateRepository,
            IMapper mapper, ILog logger)
        {
            _mapper = mapper;
            this._equipmentStateRepository = equipmentStateRepository;
            this.logger = logger;
        }

        public async Task<Response<List<EquipmentStateDTO>>> GetAllAsync()
        {
            try
            {
                return new Response<List<EquipmentStateDTO>>
               (_mapper.Map<List<EquipmentStateDTO>>(
                   await this._equipmentStateRepository.GetAllAsync()), 
                   $"Lista de estados de equipamentos");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentStateDTO>> GetByIdAsync(int id)
        {
            try
            {
                return new Response<EquipmentStateDTO>
               (_mapper.Map<EquipmentStateDTO>(
                   await this._equipmentStateRepository.GetByIdAsync(id)), 
                   $"Estado de Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<int>> RegisterAsync(EquipmentStateDTO request)
        {
            try
            {
                var result = _mapper.Map<EquipmentState>(request);
                await _equipmentStateRepository.AddAsync(result);
                return new Response<int>(result.id, Constantes.Constantes.RegistoSalvo);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<int>> UpdateAsync(EquipmentStateDTO request)
        {
            try
            {
                var result = await _equipmentStateRepository.GetByIdAsync(request.id);

                if (result != null)
                {
                    result.name = request.name;
                    await _equipmentStateRepository.UpdateAsync(result);
                    return new Response<int>(result.id, 
                        Constantes.Constantes.RegistoActualizado);
                }
                return new Response<int>(0, Constantes.Constantes.ErrorMsg);

            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<int>> RemoveAsync(int id)
        {
            try
            {
                await _equipmentStateRepository.DeleteAsync(
                    await this._equipmentStateRepository.GetByIdAsync(id));
                return new Response<int>(id, Constantes.Constantes.RegistoEliminado);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }
    }
}