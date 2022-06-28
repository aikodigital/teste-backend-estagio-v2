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
    public class EquipmentModelService : IEquipmentModelService
    {
        private IRepository<EquipmentModelEntity> _repository;
        private readonly IMapper _mapper;
        public EquipmentModelService(IRepository<EquipmentModelEntity> repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }
        public async Task<bool> Delete(Guid id)
        {
            return await _repository.DeleteAsync(id);
        }

        public async Task<EquipmentModelDto> Get(Guid id)
        {
            var entity = await _repository.SelectAsync(id);
            return _mapper.Map<EquipmentModelDto>(entity) ?? new EquipmentModelDto();
        }

        public async Task<IEnumerable<EquipmentModelDto>> GetAll()
        {
            var listEntity = await _repository.SelectAsync();
            return _mapper.Map<IEnumerable<EquipmentModelDto>>(listEntity);
        }

        public async Task<EquipmentModelDto> Post(EquipmentModelDto EquipmentModel)
        {
            var model = _mapper.Map<EquipmentModelTemplate>(EquipmentModel);
            var entity = _mapper.Map<EquipmentModelEntity>(model);
            var result = await _repository.InsertAsync(entity);
            return _mapper.Map<EquipmentModelDto>(result);
        }

        public async Task<EquipmentModelDto> Put(EquipmentModelDto EquipmentModel)
        {
            var model = _mapper.Map<EquipmentModelTemplate>(EquipmentModel);
            var entity = _mapper.Map<EquipmentModelEntity>(model);
            var result = await _repository.UpdateAsync(entity);
            return _mapper.Map<EquipmentModelDto>(result);
        }
    }
}
