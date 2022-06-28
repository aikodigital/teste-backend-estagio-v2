using AutoMapper;
using Domain.Dtos.Equipment;
using Domain.Dtos.Equipments;
using Domain.Models;
using Domain.Template;
using System;
using System.Collections.Generic;
using System.Text;

namespace CrossCutting.Mappings
{
    public class DtoToModelProfile: Profile
    {
        public DtoToModelProfile()
        {
            CreateMap<EquipmentTemplate, EquipmentDto>()
                .ReverseMap();
            CreateMap<EquipmentModelTemplate, EquipmentModelDto>()
                .ReverseMap();
            CreateMap<EquipmentStateTemplate, EquipmentStateDto>()
                .ReverseMap();
            CreateMap<EquipmentModelStateHourlyEarningsTemplate, EquipmentModelStateHourlyEarningsDto>()
                .ReverseMap();
            CreateMap<EquipmentStateHistoryTemplate, EquipmentStateHistoryDto>()
                .ReverseMap();
            CreateMap<EquipmentPositionHistoryTemplate, EquipmentPositionHistoryDto>()
                .ReverseMap();
        }
    }
}
