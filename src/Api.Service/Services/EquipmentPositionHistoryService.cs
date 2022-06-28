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
    public class EquipmentPositionHistoryService : IEquipmentPositionHistoryService
    {
        private IEquipmentPositionHistoryRepository _repository;
        private readonly IMapper _mapper;
        public EquipmentPositionHistoryService(IEquipmentPositionHistoryRepository repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }
        public async Task<bool> Delete(Guid id)
        {
            return await _repository.DeleteAsync(id);
        }

        public async Task<EquipmentPositionHistoryDto> Get(Guid id)
        {
            var entity = await _repository.SelectAsync(id);
            return _mapper.Map<EquipmentPositionHistoryDto>(entity) ?? new EquipmentPositionHistoryDto();
        }

        public async Task<IEnumerable<EquipmentPositionHistoryDto>> GetAll()
        {
            var listEntity = await _repository.SelectAsync();
            return _mapper.Map<IEnumerable<EquipmentPositionHistoryDto>>(listEntity);
        }

        public async Task<EquipmentPositionHistoryDto> Post(EquipmentPositionHistoryDto EquipmentPositionHistory)
        {
            var model = _mapper.Map<EquipmentPositionHistoryTemplate>(EquipmentPositionHistory);
            var entity = _mapper.Map<EquipmentPositionHistoryEntity>(model);
            var result = await _repository.InsertAsync(entity);
            return _mapper.Map<EquipmentPositionHistoryDto>(result);
        }

        public async Task<EquipmentPositionHistoryDto> Put(EquipmentPositionHistoryDto EquipmentPositionHistory)
        {
            var model = _mapper.Map<EquipmentPositionHistoryTemplate>(EquipmentPositionHistory);
            var entity = _mapper.Map<EquipmentPositionHistoryEntity>(model);
            var result = await _repository.UpdateAsync(entity);
            return _mapper.Map<EquipmentPositionHistoryDto>(result);
        }
        public async Task<EquipmentPositionHistoryDto> GetActualEquipment(Guid idEquipment)
        {
            var entity = await _repository.GetActualEquipmentPosition(idEquipment);
            return _mapper.Map<EquipmentPositionHistoryDto>(entity);
        }
    }
}