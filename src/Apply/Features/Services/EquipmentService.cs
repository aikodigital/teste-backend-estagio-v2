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
    public class EquipmentService : IEquipmentService
    {
        private readonly IMapper _mapper;
        private readonly IEquipmentRepository _equipmentRepository;
        private readonly IEquipmentPositionHistoryRepository _equipmentPositionHistoryRepository;
        private readonly IEquipmentStateHistoryRepository _equipmentStateHistoryRepository;
        private readonly IEquipmentModelStateHourlyEarningsRepository _equipmentModelStateHourlyEarningsRepository;
        private ILog logger;

        public EquipmentService(
            IEquipmentRepository equipmentRepository,
            IEquipmentPositionHistoryRepository equipmentPositionHistoryRepository,
            IEquipmentStateHistoryRepository equipmentStateHistoryRepository,
            IEquipmentModelStateHourlyEarningsRepository equipmentModelStateHourlyEarningsRepository,
            IMapper mapper, 
            ILog logger)
        {
            _mapper = mapper;
            this._equipmentRepository = equipmentRepository;
            this.logger = logger;
            _equipmentPositionHistoryRepository = equipmentPositionHistoryRepository;
            _equipmentStateHistoryRepository = equipmentStateHistoryRepository;
            _equipmentModelStateHourlyEarningsRepository = equipmentModelStateHourlyEarningsRepository;
        }

        public async Task<Response<List<EquipmentDTO>>> GetAllAsync()
        {
            try
            {
                return new Response<List<EquipmentDTO>>
               (_mapper.Map<List<EquipmentDTO>>(await this._equipmentRepository.GetAllAsync()), $"Lista de equipamentos");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentDTO>> GetByIdAsync(Guid id)
        {
            try
            {
                return new Response<EquipmentDTO>
               (_mapper.Map<EquipmentDTO>(await this._equipmentRepository.GetByGUIDAsync(id)), $"Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentDTO>> GetPercProdutByIdAsync(Guid id)
        {
            try
            {
                return new Response<EquipmentDTO>
               (_mapper.Map<EquipmentDTO>(await this._equipmentRepository.GetByGUIDAsync(id)), $"Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<Guid>> RegisterAsync(EquipmentDTO request)
        {
            try
            {
                request.Created = DateTime.Now;
                request.id = Guid.NewGuid();

                var result = _mapper.Map<Equipment>(request);
                await _equipmentRepository.AddAsync(result);
                return new Response<Guid>(result.id, Constantes.Constantes.RegistoSalvo);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<Guid>> UpdateAsync(EquipmentDTO request)
        {
            try
            {
                var result = await _equipmentRepository.GetByGUIDAsync(request.id);

                if (result != null)
                {
                    result.name = request.name;
                    result.equipmentModel = request.equipmentModel;
                    result.LastModified = DateTime.Now;
                    await _equipmentRepository.UpdateAsync(result);
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
                await _equipmentRepository.DeleteAsync(await this._equipmentRepository.GetByGUIDAsync(id));
                return new Response<Guid>(id, Constantes.Constantes.RegistoEliminado);
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }
        }

        public async Task<Response<EquipmentPositionHistoryDTO>> GetPosicaoAtualById(Guid id)
        {
            try
            {
                return new Response<EquipmentPositionHistoryDTO>
               (_mapper.Map<EquipmentPositionHistoryDTO>(
                   await _equipmentPositionHistoryRepository.GetPosicaoAtualById(id)),
                   $"Posição atual Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<EquipmentStateHistoryDTO>> GetEstadoAtualById(Guid id)
        {
            try
            {
                return new Response<EquipmentStateHistoryDTO>
               (_mapper.Map<EquipmentStateHistoryDTO>(
                   await this._equipmentStateHistoryRepository.GetEstadoAtualById(id)), 
                   $"Estado atual do Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<int>> GetGanhoByEquipamentoById(Guid id)
        {
            try
            {
                var equipamento = await _equipmentRepository.GetByGUIDAsync(id);

                var horasModeloOperando = await _equipmentModelStateHourlyEarningsRepository
                    .GetQuantHorasOperando(equipamento.equipmentModel);

                var horasModeloManutencao = await _equipmentModelStateHourlyEarningsRepository
                    .GetQuantHorasManutencao(equipamento.equipmentModel);

                var horasEquipamentoOperando = await _equipmentStateHistoryRepository
                    .GetQuantHorasOperando(equipamento.id);

                var horasEquipamentoManutencao = await _equipmentStateHistoryRepository
                    .GetQuantHorasManutencao(equipamento.id);

                var resultado = horasModeloOperando * horasEquipamentoOperando
                    + horasModeloManutencao * horasEquipamentoManutencao;

                return new Response<int>(resultado, $"Ganho do Equipamento por id");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }

        public async Task<Response<string>> GetProdutividadeByEquipamentoById(Guid id)
        {
            try
            {
                var operandoHoje = await _equipmentStateHistoryRepository
                    .GetQuantHorasOperandoHoje(id);

                var geralHoje = await _equipmentStateHistoryRepository
                    .GetQuantHorasHoje(id);

                var resultado = operandoHoje / geralHoje * 100;

                return new Response<string>(resultado+"%", 
                    $"Percentual da Produtividade do Equipamento");
            }
            catch (System.Exception ex)
            {
                this.logger.Error(ex.Message);
                throw new ApiException(ex.Message);
            }

        }
    }
}