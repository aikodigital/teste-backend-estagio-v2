using Api.Domain.Entities;
using AutoMapper;
using Domain.Dtos.Equipment;
using Domain.Dtos.Equipments;
using Domain.Entities;
using System;
using System.Collections.Generic;
using System.Text;

namespace CrossCutting.Mappings
{
    public class EntityToDtoProfile : Profile
{
        public EntityToDtoProfile()
        {
            CreateMap<EquipmentDto, EquipmentEntity>()
                .ReverseMap();
            CreateMap<EquipmentModelDto, EquipmentModelEntity>()
                .ReverseMap();
            CreateMap<EquipmentStateDto, EquipmentStateEntity>()
                .ReverseMap();
            CreateMap<EquipmentModelStateHourlyEarningsDto, EquipmentModelStateHourlyEarningsEntity>()
                .ReverseMap();
            CreateMap<EquipmentStateHistoryDto, EquipmentStateHistoryEntity>()
                .ReverseMap();
            CreateMap<EquipmentPositionHistoryDto, EquipmentPositionHistoryEntity>()
                .ReverseMap();
        }    
    }
}
