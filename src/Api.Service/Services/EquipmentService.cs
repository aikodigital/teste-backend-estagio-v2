using Api.Domain.Entities;
using Api.Domain.Interfaces;
using AutoMapper;
using Domain.Dtos.Equipments;
using Domain.Interfaces.Services;
using Domain.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.Services
{
    public class EquipmentService : IEquipmentService
    {
        private IRepository<EquipmentEntity> _repository;
        private readonly IMapper _mapper;
        public EquipmentService(IRepository<EquipmentEntity> repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }
        public async Task<bool> Delete(Guid id)
        {
            return await _repository.DeleteAsync(id);
        }

        public async Task<EquipmentDto> Get(Guid id)
        {
            var entity = await _repository.SelectAsync(id);
            return _mapper.Map<EquipmentDto>(entity) ?? new EquipmentDto();
        }

        public async Task<IEnumerable<EquipmentDto>> GetAll()
        {
            var listEntity = await _repository.SelectAsync();
            return _mapper.Map<IEnumerable<EquipmentDto>>(listEntity);
        }

        public async Task<EquipmentDto> Post(EquipmentDto Equipment)
        {
            var model = _mapper.Map<EquipmentTemplate>(Equipment);
            var entity = _mapper.Map<EquipmentEntity>(model);
            var result = await _repository.InsertAsync(entity);
            return _mapper.Map<EquipmentDto>(result);
        }

        public async Task<EquipmentDto> Put(EquipmentDto Equipment)
        {
            var model = _mapper.Map<EquipmentTemplate>(Equipment);
            var entity = _mapper.Map<EquipmentEntity>(model);
            var result = await _repository.UpdateAsync(entity);
            return _mapper.Map<EquipmentDto>(result);
        }
    }
}

