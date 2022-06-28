using AutoMapper;
using Equipments.Data;
using Equipments.Data.Dtos.Equipment_Position_History;
using Equipments.Models;
using FluentResults;
using Microsoft.EntityFrameworkCore;
using Npgsql.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Equipments.Services
{
    public class EquipmentPositionHistoryService
    {
        private IMapper _mapper;
        private AppDbContext _context;

        public EquipmentPositionHistoryService(IMapper mapper, AppDbContext context)
        {
            _mapper = mapper;
            _context = context;
        }

        public ReadEquipmentPositionHistoryDto AddPosition(CreateEquipmentPositionHistoryDto positionDto)
        {
            Equipment_Position_History position = _mapper.Map<Equipment_Position_History>(positionDto);
            _context.equipment_position_history.Add(position);
            _context.SaveChanges();
            return _mapper.Map<ReadEquipmentPositionHistoryDto>(position);
        }


        public List<ReadEquipmentPositionHistoryDto> GetPositionHistoryByEquipmentId(Guid id)
        {         
            List<Equipment_Position_History> positionHistory = _context.equipment_position_history.ToList();
            if (positionHistory == null)
            {
                return null;
            }
            IEnumerable<Equipment_Position_History> query = from equipment_position_history in positionHistory
                                            where equipment_position_history.equipment_id == id
                                                            select equipment_position_history;

            positionHistory = query.ToList();
            if (positionHistory == null)
            {
                return null;
            }
            return _mapper.Map<List<ReadEquipmentPositionHistoryDto>>(positionHistory);
        }

 
        public ReadEquipmentPositionHistoryDto GetLastPosition(Guid id)
        {
            List<Equipment_Position_History> positionHistory = _context.equipment_position_history.ToList();
            Equipment_Position_History position;
            if (positionHistory == null)
            {
                return null;
            }
            IEnumerable<Equipment_Position_History> query = from equipment_position_history in positionHistory
                                                            where equipment_position_history.equipment_id == id
                                                            orderby equipment_position_history.date
                                                            select equipment_position_history;

            position = query.ToList().Last();

            return _mapper.Map<ReadEquipmentPositionHistoryDto>(position); ;
        }


        public Result UpdatePosition(Guid id, DateTime date, UpdateEquipmentPositionHistoryDto positionDto)
        {
            Equipment_Position_History positionHistory = _context.equipment_position_history.FirstOrDefault(positionHistory => positionHistory.equipment_id == id && positionHistory.date == date);
            if (positionHistory == null)
            {
                return Result.Fail("Position doesn't exist");
            }
            _mapper.Map(positionDto, positionHistory);
            _context.SaveChanges();
            return Result.Ok();
        }

        public Result DeletePosition(Guid id, DateTime date)
        {
            Equipment_Position_History positionHistory = _context.equipment_position_history.FirstOrDefault(positionHistory => positionHistory.equipment_id == id && positionHistory.date == date);
            if (positionHistory == null)
            {
                return Result.Fail("Position doesn't exist");
            }
            _context.Remove(positionHistory);
            _context.SaveChanges();
            return Result.Ok();
        }
    }
}
