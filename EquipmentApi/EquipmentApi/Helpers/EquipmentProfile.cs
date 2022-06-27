using AutoMapper;
using EquipmentApi.Dtos.CreateDtos;
using EquipmentApi.Dtos.DeleteDtos;
using EquipmentApi.Dtos.ReadDtos;
using EquipmentApi.Entities;

namespace EquipmentApi.Helpers
{
    public class EquipmentProfile : Profile
    {
        public EquipmentProfile()
        {
            CreateMap<EquipmentModel, EquipmentModelShowDto>().ReverseMap();
            CreateMap<Equipment, EquipmentDto>().ReverseMap();
            CreateMap<EquipmentModelStateHourlyEarning, EquipmentModelStateHourlyEarningDto>().ReverseMap();
            CreateMap<EquipmentPositionHistory, EquipmentPositionHistoryDto>().ReverseMap();
            CreateMap<EquipmentStateHistory, EquipmentStateHistoryDto>().ReverseMap();
            CreateMap<EquipmentState, EquipmentStateWithoutIdDto>().ReverseMap();

            CreateMap<EquipmentCreateDto, Equipment>().ReverseMap();
            CreateMap<EquipmentModelCreateDto, EquipmentModel>().ReverseMap();
            CreateMap<EquipmentModelStateHourlyEarningCreateDto, EquipmentModelStateHourlyEarning>().ReverseMap();
            CreateMap<EquipmentPositionHistoryCreateDto, EquipmentPositionHistory>().ReverseMap();
            CreateMap<EquipmentStateHistoryCreateDto, EquipmentStateHistory>().ReverseMap();

            CreateMap<EquipmentStateHistoryDeleteDto, EquipmentStateHistory>().ReverseMap();
            CreateMap<EquipmentModelStateHourlyEarningDeleteDto, EquipmentModelStateHourlyEarning>().ReverseMap();
            CreateMap<EquipmentPositionHistoryDeleteDto, EquipmentPositionHistory>().ReverseMap();
        }
    }
}
