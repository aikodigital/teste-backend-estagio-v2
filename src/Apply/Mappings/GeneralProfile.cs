using System;
using AutoMapper;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TesteEstágioBackendV2.src.Apply.DTOs;
using TesteEstágioBackendV2.src.domain;

namespace TesteEstágioBackendV2.src.Apply.Mappings
{
    public class GeneralProfile : Profile
    {
        public GeneralProfile()
        {
            CreateMap<EquipmentDTO, Equipment>().ReverseMap();
            CreateMap<EquipmentModelDTO, EquipmentModel>().ReverseMap();
            CreateMap<EquipmentStateDTO, EquipmentState>().ReverseMap();
            CreateMap<EquipmentModelStateHourlyEarningsDTO, EquipmentModelStateHourlyEarnings>().ReverseMap();
            CreateMap<EquipmentPositionHistoryDTO, EquipmentPositionHistory>().ReverseMap();
            CreateMap<EquipmentStateHistoryDTO, EquipmentStateHistory>().ReverseMap();
        }
        
    }
}