using AutoMapper;
using Equipments.Data;
using Equipments.Data.Dtos.Equipment_Model_State_Hourly_earnings;
using Equipments.Models;
using FluentResults;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Equipments.Services
{
    public class EquipmentModelStateHourlyEarningsService
    {
        private IMapper _mapper;
        private AppDbContext _context;

        public EquipmentModelStateHourlyEarningsService(IMapper mapper, AppDbContext context)
        {
            _mapper = mapper;
            _context = context;
        }

        public ReadEquipmentModelStateHourlyEarningsDto AddHourlyEarnings(CreateEquipmentModelStateHourlyEarningsDto equipmentDto)
        {
            Equipment_Model_State_Hourly_Earnings equipment = _mapper.Map<Equipment_Model_State_Hourly_Earnings>(equipmentDto);
            _context.equipment_model_state_hourly_earnings.Add(equipment);
            _context.SaveChanges();
            return _mapper.Map<ReadEquipmentModelStateHourlyEarningsDto>(equipment);
        }


        public List<ReadEquipmentModelStateHourlyEarningsDto> GetHourlyEarnings()
        {
            List<Equipment_Model_State_Hourly_Earnings> equipments = _context.equipment_model_state_hourly_earnings.Include("equipment_model").Include("equipment_state").ToList();
            if (equipments == null)
            {
                return null;
            }            
            return _mapper.Map<List<ReadEquipmentModelStateHourlyEarningsDto>>(equipments);
        }


        public ReadEquipmentModelStateHourlyEarningsDto GetHourlyEarningsById(Guid ?equipment_model_id, Guid ?equipment_state_id)
        {
            Equipment_Model_State_Hourly_Earnings equipment = _context.equipment_model_state_hourly_earnings.Include("equipment_model").Include("equipment_state").FirstOrDefault(
                equipment => equipment.equipment_model_id == equipment_model_id 
                && equipment.equipment_state_id == equipment_state_id);

            if (equipment != null)
            {
                ReadEquipmentModelStateHourlyEarningsDto equipmentDto = _mapper.Map<ReadEquipmentModelStateHourlyEarningsDto>(equipment);
                return equipmentDto;
            }
            return null;
        }

        public Result UpdateHourlyEarnings(Guid equipment_model_id, Guid equipment_state_id, UpdateEquipmentModelStateHourlyEarningsDto equipmentDto)
        {
            Equipment_Model_State_Hourly_Earnings equipment = _context.equipment_model_state_hourly_earnings.FirstOrDefault(
                equipment => equipment.equipment_model_id == equipment_model_id 
                && equipment.equipment_state_id == equipment_state_id);

            if (equipment == null)
            {
                return Result.Fail("This data doesn't exist");
            }
            _mapper.Map(equipmentDto, equipment);
            _context.SaveChanges();
            return Result.Ok();
        }

        public Result DeleteHourlyEarnings(Guid equipment_model_id, Guid equipment_state_id)
        {
            Equipment_Model_State_Hourly_Earnings equipment = _context.equipment_model_state_hourly_earnings.FirstOrDefault(
                equipment => equipment.equipment_model_id == equipment_model_id
                && equipment.equipment_state_id == equipment_state_id);

            if (equipment == null)
            {
                return Result.Fail("This data doesn't exist");
            }
            _context.Remove(equipment);
            _context.SaveChanges();
            return Result.Ok();
        }
    }
}
