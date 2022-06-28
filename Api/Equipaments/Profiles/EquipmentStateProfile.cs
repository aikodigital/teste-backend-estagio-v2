using AutoMapper;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment_State;

namespace Equipments.Profiles
{
    public class EquipmentStateProfile : Profile
    {
       public EquipmentStateProfile()
       {
            CreateMap<CreateEquipmentStateDto, Equipment_State>();
            CreateMap<Equipment_State, ReadEquipmentStateDto>();
            CreateMap<UpdateEquipmentStateDto, Equipment_State>();
        }
        
    }
}
