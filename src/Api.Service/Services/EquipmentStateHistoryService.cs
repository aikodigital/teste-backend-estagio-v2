using Api.Domain.Interfaces;
using AutoMapper;
using Domain.Dtos.Equipment;
using Domain.Entities;
using Domain.Interfaces.Services;
using Domain.Repository;
using Domain.Template;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.Services
{
    public class EquipmentStateHistoryService : IEquipmentStateHistoryService
    {
        private IEquipmentStateHistoryRepository _repository;
        private readonly IMapper _mapper;
        public EquipmentStateHistoryService(IEquipmentStateHistoryRepository repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }
        public async Task<bool> Delete(Guid id)
        {
            return await _repository.DeleteAsync(id);
        }

        public async Task<EquipmentStateHistoryDto> Get(Guid id)
        {
            var entity = await _repository.SelectAsync(id);
            return _mapper.Map<EquipmentStateHistoryDto>(entity) ?? new EquipmentStateHistoryDto();
        }

        public async Task<IEnumerable<EquipmentStateHistoryDto>> GetAll()
        {
            var listEntity = await _repository.SelectAsync();
            return _mapper.Map<IEnumerable<EquipmentStateHistoryDto>>(listEntity);
        }

        public async Task<EquipmentStateHistoryDto> Post(EquipmentStateHistoryDto EquipmentStateHistory)
        {
            var model = _mapper.Map<EquipmentStateHistoryTemplate>(EquipmentStateHistory);
            var entity = _mapper.Map<EquipmentStateHistoryEntity>(model);
            var result = await _repository.InsertAsync(entity);
            return _mapper.Map<EquipmentStateHistoryDto>(result);
        }

        public async Task<EquipmentStateHistoryDto> Put(EquipmentStateHistoryDto EquipmentStateHistory)
        {
            var model = _mapper.Map<EquipmentStateHistoryTemplate>(EquipmentStateHistory);
            var entity = _mapper.Map<EquipmentStateHistoryEntity>(model);
            var result = await _repository.UpdateAsync(entity);
            return _mapper.Map<EquipmentStateHistoryDto>(result);
        }

        public async Task<EquipmentStateHistoryDto> GetActualEquipment(Guid idEquipment)
        {
            var entity = await _repository.GetActualEquipmentState(idEquipment);
            return _mapper.Map<EquipmentStateHistoryDto>(entity);
        }
    }
}
