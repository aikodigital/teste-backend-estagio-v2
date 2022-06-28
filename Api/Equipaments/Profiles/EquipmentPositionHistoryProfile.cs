using AutoMapper;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment_Position_History;

namespace Equipments.Profiles
{
    public class EquipmentPositionHistoryProfile : Profile
    {
       public EquipmentPositionHistoryProfile()
       {
            CreateMap<CreateEquipmentPositionHistoryDto, Equipment_Position_History>();
            CreateMap<Equipment_Position_History, ReadEquipmentPositionHistoryDto>();
            CreateMap<UpdateEquipmentPositionHistoryDto, Equipment_Position_History>();
        }
        
    }
}
