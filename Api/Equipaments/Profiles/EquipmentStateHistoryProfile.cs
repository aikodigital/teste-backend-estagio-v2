using AutoMapper;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment_State_History;

namespace Equipments.Profiles
{
    public class EquipmentStateHistoryProfile : Profile
    {
       public EquipmentStateHistoryProfile()
       {
            CreateMap<CreateEquipmentStateHistoryDto, Equipment_State_History>();
            CreateMap<Equipment_State_History, ReadEquipmentStateHistoryDto>();
            CreateMap<Equipment_State_History, ReadListEquipmentStateHistoryDto>();
            CreateMap<UpdateEquipmentStateHistoryDto, Equipment_State_History>();
        }
        
    }
}
