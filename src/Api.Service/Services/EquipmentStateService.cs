using Api.Domain.Interfaces;
using AutoMapper;
using Domain.Dtos.Equipment;
using Domain.Entities;
using Domain.Interfaces.Services;
using Domain.Template;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.Services
{
    public class EquipmentStateService : IEquipmentStateService
    {
        private IRepository<EquipmentStateEntity> _repository;
        private readonly IMapper _mapper;
        public EquipmentStateService(IRepository<EquipmentStateEntity> repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }
        public async Task<bool> Delete(Guid id)
        {
            return await _repository.DeleteAsync(id);
        }

        public async Task<EquipmentStateDto> Get(Guid id)
        {
            var entity = await _repository.SelectAsync(id);
            return _mapper.Map<EquipmentStateDto>(entity) ?? new EquipmentStateDto();
        }

        public async Task<IEnumerable<EquipmentStateDto>> GetAll()
        {
            var listEntity = await _repository.SelectAsync();
            return _mapper.Map<IEnumerable<EquipmentStateDto>>(listEntity);
        }

        public async Task<EquipmentStateDto> Post(EquipmentStateDto EquipmentState)
        {
            var model = _mapper.Map<EquipmentStateTemplate>(EquipmentState);
            var entity = _mapper.Map<EquipmentStateEntity>(model);
            var result = await _repository.InsertAsync(entity);
            return _mapper.Map<EquipmentStateDto>(result);
        }

        public async Task<EquipmentStateDto> Put(EquipmentStateDto EquipmentState)
        {
            var model = _mapper.Map<EquipmentStateTemplate>(EquipmentState);
            var entity = _mapper.Map<EquipmentStateEntity>(model);
            var result = await _repository.UpdateAsync(entity);
            return _mapper.Map<EquipmentStateDto>(result);
        }
    }
}
