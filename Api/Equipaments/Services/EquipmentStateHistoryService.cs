using AutoMapper;
using Equipments.Data;
using Equipments.Data.Dtos.Equipment_State_History;
using Equipments.Models;
using FluentResults;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Equipments.Services
{
    public class EquipmentStateHistoryService
    {
        private IMapper _mapper;
        private AppDbContext _context;

        public EquipmentStateHistoryService(IMapper mapper, AppDbContext context)
        {
            _mapper = mapper;
            _context = context;
        }

        public ReadEquipmentStateHistoryDto AddStateHistory(CreateEquipmentStateHistoryDto stateHistoryDto)
        {
            Equipment_State_History stateHistory = _mapper.Map<Equipment_State_History>(stateHistoryDto);
            _context.equipment_state_history.Add(stateHistory);
            _context.SaveChanges();
            return _mapper.Map<ReadEquipmentStateHistoryDto>(stateHistory);
        }


        public List<ReadListEquipmentStateHistoryDto> GetStateHistoryById(Guid equipment_id)
        {
            List<Equipment_State_History> stateHistory = _context.equipment_state_history.ToList();
            if (stateHistory == null)
            {
                return null;
            }
            IEnumerable<Equipment_State_History> query = from equipment_state_history in stateHistory
                                                            where equipment_state_history.equipment_id == equipment_id
                                                            select equipment_state_history;

            stateHistory = query.ToList();
            if (stateHistory == null)
            {
                return null;
            }
            return _mapper.Map<List<ReadListEquipmentStateHistoryDto>>(stateHistory);
        }


        public ReadEquipmentStateHistoryDto GetLastStateHistory(Guid equipment_id)
        {
            List<Equipment_State_History> stateHistory = _context.equipment_state_history.Include("equipment").Include("equipment_state").ToList();
            Equipment_State_History state;

            if (stateHistory == null)
            {
                return null;
            }
            IEnumerable<Equipment_State_History> queryStateHistory = from equipment_state_history in stateHistory
                                                              where equipment_state_history.equipment_id == equipment_id
                                                              orderby equipment_state_history.date
                                                              select equipment_state_history;


            state = queryStateHistory.ToList().Last();

            return _mapper.Map<ReadEquipmentStateHistoryDto>(state); ;
        }

        public Result UpdateStateHistory(Guid equipment_id, DateTime date, UpdateEquipmentStateHistoryDto equipmentDto)
        {
            Equipment_State_History stateHistory = _context.equipment_state_history.FirstOrDefault(
                stateHistory => stateHistory.equipment_id == equipment_id
                && stateHistory.date == date);

            if (stateHistory == null)
            {
                return Result.Fail("This data doesn't exist");
            }
            _mapper.Map(equipmentDto, stateHistory);
            _context.SaveChanges();
            return Result.Ok();
        }

        public Result DeleteStateHistory(Guid equipment_id, DateTime date)
        {
            Equipment_State_History stateHistory = _context.equipment_state_history.FirstOrDefault(
                stateHistory => stateHistory.equipment_id == equipment_id
                && stateHistory.date == date);

            if (stateHistory == null)
            {
                return Result.Fail("This data doesn't exist");
            }
            _context.Remove(stateHistory);
            _context.SaveChanges();
            return Result.Ok();
        }
    }
}
