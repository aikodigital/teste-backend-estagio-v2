using AutoMapper;
using Equipments.Data;
using Equipments.Data.Dtos.Equipment_State;
using Equipments.Models;
using FluentResults;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Equipments.Services
{
    public class EquipmentStateService
    {
        private IMapper _mapper;
        private AppDbContext _context;

        public EquipmentStateService(IMapper mapper, AppDbContext context)
        {
            _mapper = mapper;
            _context = context;
        }

        public ReadEquipmentStateDto AddEquipmentState(CreateEquipmentStateDto equipmentStateDto)
        {
            Equipment_State equipmentState = _mapper.Map<Equipment_State>(equipmentStateDto);
            _context.equipment_state.Add(equipmentState);
            _context.SaveChanges();
            return _mapper.Map<ReadEquipmentStateDto>(equipmentState);
        }


        public List<ReadEquipmentStateDto> GetEquipmentState(string equipmentStateName)
        {
            List<Equipment_State> equipmentsState = _context.equipment_state.ToList();
            if (equipmentsState == null)
            {
                return null;
            }
            if (!string.IsNullOrEmpty(equipmentStateName))
            {
                IEnumerable<Equipment_State> query = from equipment in equipmentsState
                                               where equipment.name.Contains(equipmentStateName, StringComparison.InvariantCultureIgnoreCase)
                                               select equipment;

                equipmentsState = query.ToList();
            }
            return _mapper.Map<List<ReadEquipmentStateDto>>(equipmentsState);
        }

        public ReadEquipmentStateDto GetEquipmentStateById(Guid id)
        {
            Equipment_State equipmentState = _context.equipment_state.FirstOrDefault(equipmentState => equipmentState.id == id);
            if (equipmentState != null)
            {               
                return _mapper.Map<ReadEquipmentStateDto>(equipmentState); 
            }
            return null;
        }

        public Result UpdateEquipmentState(Guid id, UpdateEquipmentStateDto updateEquipmentStateDto)
        {
            Equipment_State equipmentState = _context.equipment_state.FirstOrDefault(equipmentState => equipmentState.id == id);
            if (equipmentState == null)
            {
                return Result.Fail("Equipment doesn't exist");
            }
            _mapper.Map(updateEquipmentStateDto, equipmentState);
            _context.SaveChanges();
            return Result.Ok();
        }

        public Result DeleteEquipmentState(Guid id)
        {
            Equipment_State equipmentState = _context.equipment_state.FirstOrDefault(equipmentState => equipmentState.id == id);
            if (equipmentState == null)
            {
                return Result.Fail("Equipment State doesn't exist");
            }
            _context.Remove(equipmentState);
            _context.SaveChanges();
            return Result.Ok();
        }
    }
}
