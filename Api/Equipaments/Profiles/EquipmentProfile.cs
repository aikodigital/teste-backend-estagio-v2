using AutoMapper;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment;

namespace Equipments.Profiles
{
    public class EquipmentProfile : Profile
    {
       public EquipmentProfile()
       {
            CreateMap<CreateEquipmentDto, Equipment>();
            CreateMap<Equipment, ReadEquipmentDto>();
            CreateMap<UpdateEquipmentDto, Equipment>();
        }
        
    }
}
