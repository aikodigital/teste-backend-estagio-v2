using Api.Domain.Entities;
using AutoMapper;
using Domain.Entities;
using Domain.Models;
using Domain.Template;
using System;
using System.Collections.Generic;
using System.Text;

namespace CrossCutting.Mappings
{
    public class ModelToEntityProfile : Profile
    {
        public ModelToEntityProfile()
        {
            CreateMap<EquipmentEntity, EquipmentTemplate>()
                .ReverseMap();
            CreateMap<EquipmentModelEntity, EquipmentModelTemplate>()
                .ReverseMap();
            CreateMap<EquipmentStateEntity, EquipmentStateTemplate>()
                .ReverseMap();
            CreateMap<EquipmentModelStateHourlyEarningsEntity, EquipmentModelStateHourlyEarningsTemplate>()
                .ReverseMap();
            CreateMap<EquipmentStateHistoryEntity, EquipmentStateHistoryTemplate>()
                .ReverseMap();
            CreateMap<EquipmentPositionHistoryEntity, EquipmentPositionHistoryTemplate>()
                .ReverseMap();
        }
    }
}
