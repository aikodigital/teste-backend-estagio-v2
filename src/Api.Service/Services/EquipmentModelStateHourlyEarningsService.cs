using Api.Domain.Interfaces;
using AutoMapper;
using Domain.Dtos.Equipment;
using Domain.Entities;
using Domain.Interfaces.Services.User;
using Domain.Template;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.Services
{
    public class EquipmentModelStateHourlyEarningsService : IEquipmentModelStateHourlyEarningsService
    {
        private IRepository<EquipmentModelStateHourlyEarningsEntity> _repository;
        private readonly IMapper _mapper;
        public EquipmentModelStateHourlyEarningsService(IRepository<EquipmentModelStateHourlyEarningsEntity> repository, IMapper mapper)
        {
            _repository = repository;
            _mapper = mapper;
        }
        public async Task<bool> Delete(Guid id)
        {
            return await _repository.DeleteAsync(id);
        }

        public async Task<EquipmentModelStateHourlyEarningsDto> Get(Guid id)
        {
            var entity = await _repository.SelectAsync(id);
            return _mapper.Map<EquipmentModelStateHourlyEarningsDto>(entity) ?? new EquipmentModelStateHourlyEarningsDto();
        }

        public async Task<IEnumerable<EquipmentModelStateHourlyEarningsDto>> GetAll()
        {
            var listEntity = await _repository.SelectAsync();
            return _mapper.Map<IEnumerable<EquipmentModelStateHourlyEarningsDto>>(listEntity);
        }

        public async Task<EquipmentModelStateHourlyEarningsDto> Post(EquipmentModelStateHourlyEarningsDto EquipmentModelStateHourlyEarnings)
        {
            var model = _mapper.Map<EquipmentModelStateHourlyEarningsTemplate>(EquipmentModelStateHourlyEarnings);
            var entity = _mapper.Map<EquipmentModelStateHourlyEarningsEntity>(model);
            var result = await _repository.InsertAsync(entity);
            return _mapper.Map<EquipmentModelStateHourlyEarningsDto>(result);
        }

        public async Task<EquipmentModelStateHourlyEarningsDto> Put(EquipmentModelStateHourlyEarningsDto EquipmentModelStateHourlyEarnings)
        {
            var model = _mapper.Map<EquipmentModelStateHourlyEarningsTemplate>(EquipmentModelStateHourlyEarnings);
            var entity = _mapper.Map<EquipmentModelStateHourlyEarningsEntity>(model);
            var result = await _repository.UpdateAsync(entity);
            return _mapper.Map<EquipmentModelStateHourlyEarningsDto>(result);
        }
    }
}

