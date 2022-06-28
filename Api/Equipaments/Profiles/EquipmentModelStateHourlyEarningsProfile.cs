using AutoMapper;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment_Model_State_Hourly_earnings;

namespace Equipments.Profiles
{
    public class EquipmentModelStateHourlyEarningsProfile : Profile
    {
       public EquipmentModelStateHourlyEarningsProfile()
       {
            CreateMap<CreateEquipmentModelStateHourlyEarningsDto, Equipment_Model_State_Hourly_Earnings>();
            CreateMap<Equipment_Model_State_Hourly_Earnings, ReadEquipmentModelStateHourlyEarningsDto>();
            CreateMap<UpdateEquipmentModelStateHourlyEarningsDto, Equipment_Model_State_Hourly_Earnings>();
        }
        
    }
}
