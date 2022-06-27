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
    public class EquipmentModelStateHourlyEarningsService : IEquipmentModelStateHourlyEarningsService
    {
         private readonly IMapper _mapper;
        private readonly IEquipmentModelStateHourlyEarningsRepository _equipmentModelStateHourlyEarningsRepository;
        private readonly IEquipmentModelRepository _equipmentModelRepository;
        private ILog logger;

        public EquipmentModelStateHourlyEarningsService(
            IEquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository,
            IEquipmentModelRepository equipmentModelRepository,
            IMapper mapper, ILog logger)
        {
            _mapper = mapper;
            this._equipmentModelStateHourlyEarningsRepository = equipmentModelStateHourlyEarningsRepository;
            this.logger = logger;
            _equipmentModelRepository = equipmentModelRepository;
        }

        public async Task<Response<List<EquipmentModelStateHourlyEarningsDTO>>> GetAllAsync()
        {
            try
            {
                return new Response<List<EquipmentModelStateHourlyEarningsDTO>>
               (_mapper.Map<List<EquipmentModelStateHourlyEarningsDTO>>(
                   await this._equipmentModelStateHourlyEarningsRepository.GetAllAsync()),
                   $"Lista de Ganhos por hora e estado");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentModelStateHourlyEarningsDTO>> GetByIdAsync(Guid id)
        {
            try
            {
                return new Response<EquipmentModelStateHourlyEarningsDTO>
               (_mapper.Map<EquipmentModelStateHourlyEarningsDTO>(
                   await this._equipmentModelStateHourlyEarningsRepository.GetByGUIDAsync(id)),
                   $"Ganhos por hora e estado por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<Guid>> RegisterAsync(EquipmentModelStateHourlyEarningsDTO request)
        {
            try
            {
                request.id = Guid.NewGuid();

                var result = _mapper.Map<EquipmentModelStateHourlyEarnings>(request);
                
                await _equipmentModelStateHourlyEarningsRepository.AddAsync(result);
                return new Response<Guid>(result.id, Constantes.Constantes.RegistoSalvo);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<Guid>> UpdateAsync(EquipmentModelStateHourlyEarningsDTO request)
        {
            try
            {
                var result = await _equipmentModelStateHourlyEarningsRepository.GetByGUIDAsync(request.id);

                if (result != null)
                {
                    result.value = request.value;
                    result.equipmentModel = request.equipmentModel;
                    request.equipmentState = request.equipmentState;
                    await _equipmentModelStateHourlyEarningsRepository.UpdateAsync(result);
                    return new Response<Guid>(result.id,
                        Constantes.Constantes.RegistoActualizado);
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
                await _equipmentModelStateHourlyEarningsRepository.DeleteAsync(
                    await this._equipmentModelStateHourlyEarningsRepository.GetByGUIDAsync(id));
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