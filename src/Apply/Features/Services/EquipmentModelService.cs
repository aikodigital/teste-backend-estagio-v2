using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AutoMapper;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.Apply.Exceptions;
using TesteEstágioBackendV2.src.Apply.Interfaces;
using TesteEstágioBackendV2.src.Apply.Interfaces.NLog;
using TesteEstágioBackendV2.src.Apply.Interfaces.Repositories;
using TesteEstágioBackendV2.src.Apply.Interfaces.Services;
using TesteEstágioBackendV2.src.Apply.Wrappers;
using TesteEstágioBackendV2.src.domain;

namespace TesteEstágioBackendV2.src.Apply.Features.Services
{
    public class EquipmentModelService : IEquipmentModelService
    {
        private readonly IMapper _mapper;
        private readonly IEquipmentModelRepository _equipmentModelRepository;
        private readonly IEquipmentPositionHistoryRepository _equipmentPositionHistoryRepository;
        private readonly IEquipmentStateHistoryRepository _equipmentStateHistoryRepository;
        private readonly IEquipmentModelStateHourlyEarningsRepository _equipmentModelStateHourlyEarningsRepository;
        private ILog logger;

        public EquipmentModelService(
            IEquipmentModelRepository equipmentModelRepository,
            IEquipmentPositionHistoryRepository equipmentPositionHistoryRepository,
            IEquipmentStateHistoryRepository equipmentStateHistoryRepository,
            IEquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository,
            IMapper mapper, 
            ILog logger)
        {
            _mapper = mapper;
            this._equipmentModelRepository = equipmentModelRepository;
            this.logger = logger;
            _equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
            _equipmentStateHistoryRepository = equipmentStateHistoryRepository;
            _equipmentModelStateHourlyEarningsRepository = equipmentModelStateHourlyEarningsRepository;
        }

        public async Task<Response<List<EquipmentModelDTO>>> GetAllAsync()
        {
            try
            {
                return new Response<List<EquipmentModelDTO>>
               (_mapper.Map<List<EquipmentModelDTO>>(await this._equipmentModelRepository.GetAllAsync()), $"Lista de equipamentos");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentModelDTO>> GetByIdAsync(Guid id)
        {
            try
            {
                return new Response<EquipmentModelDTO>
               (_mapper.Map<EquipmentModelDTO>(await this._equipmentModelRepository.GetByGUIDAsync(id)), $"Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentModelDTO>> GetPercProdutByIdAsync(Guid id)
        {
            try
            {
                return new Response<EquipmentModelDTO>
               (_mapper.Map<EquipmentModelDTO>(await this._equipmentModelRepository.GetByGUIDAsync(id)), $"Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<Guid>> RegisterAsync(EquipmentModelDTO request)
        {
            try
            {
                request.Created = DateTime.Now;
                request.id = Guid.NewGuid();

                var result = _mapper.Map<EquipmentModel>(request);
                await _equipmentModelRepository.AddAsync(result);
                return new Response<Guid>(result.id, Constantes.Constantes.RegistoSalvo);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<Guid>> UpdateAsync(EquipmentModelDTO request)
        {
            try
            {
                var result = await _equipmentModelRepository.GetByGUIDAsync(request.id);

                if (result != null)
                {
                    result.name = request.name;
                    result.LastModified = DateTime.Now;
                    await _equipmentModelRepository.UpdateAsync(result);
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
                await _equipmentModelRepository.DeleteAsync(await this._equipmentModelRepository.GetByGUIDAsync(id));
                return new Response<Guid>(id, Constantes.Constantes.RegistoEliminado);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

}   }