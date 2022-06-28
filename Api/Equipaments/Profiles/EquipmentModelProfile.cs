using AutoMapper;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment;

namespace Equipments.Profiles
{
    public class EquipmentModelProfile : Profile
    {
       public EquipmentModelProfile()
       {
            CreateMap<CreateEquipmentModelDto, Equipment_Model>();
            CreateMap<Equipment_Model, ReadEquipmentModelDto>();
            CreateMap<UpdateEquipmentModelDto, Equipment_Model>();
        }
        
    }
}
