using AutoMapper;
using Equipments.Data;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment;
using System.Collections.Generic;
using System.Linq;
using System;
using FluentResults;
using Microsoft.EntityFrameworkCore;

namespace Equipments.Services
{
    public class EquipmentService
    {
        private IMapper _mapper;
        private AppDbContext _context;

        public EquipmentService(IMapper mapper, AppDbContext context)
        {
            _mapper = mapper;
            _context = context;
        }

        public ReadEquipmentDto AddEquipment(CreateEquipmentDto equipmentDto)
        {
            Equipment equipment = _mapper.Map<Equipment>(equipmentDto);
            _context.equipment.Add(equipment);
            _context.SaveChanges();
            return _mapper.Map<ReadEquipmentDto>(equipment);
        }

 
        public List<ReadEquipmentDto> GetEquipment(string equipmentName)
        {
            List<Equipment> equipments = _context.equipment.Include("equipment_model").ToList();
            if (equipments == null)
            {
                return null;
            }
            if (!string.IsNullOrEmpty(equipmentName))
            {
                IEnumerable<Equipment> query = from equipment in equipments
                                               where equipment.name.Contains(equipmentName, StringComparison.InvariantCultureIgnoreCase)
                                               select equipment;

                equipments = query.ToList();
            }
            return _mapper.Map<List<ReadEquipmentDto>>(equipments);
        }

        /*[HttpGet]
        public IActionResult RecuperaLastEquipment()
        {
            ReadEquipmentDto equipmentDto = _mapper.Map<ReadEquipmentDto>(_context.equipment.ToList().Last());
            return Ok(equipmentDto);
        }*/


        public ReadEquipmentDto GetEquipmentById(Guid id)
        {
            Equipment equipment = _context.equipment.Include("equipment_model").FirstOrDefault(equipment => equipment.id == id);
            if (equipment != null)
            {
                ReadEquipmentDto equipmentDto = _mapper.Map<ReadEquipmentDto>(equipment);
                return equipmentDto;
            }
            return null;
        }

        public Result UpdateEquipment(Guid id, UpdateEquipmentDto equipmentDto)
        {
            Equipment equipment = _context.equipment.FirstOrDefault(equipment => equipment.id == id);
            if (equipment == null)
            {
                return Result.Fail("Equipment doesn't exist");
            }
            _mapper.Map(equipmentDto, equipment);
            _context.SaveChanges();
            return Result.Ok();
        }

        public Result DeleteEquipment(Guid id)
        {
            Equipment equipment = _context.equipment.FirstOrDefault(equipment => equipment.id == id);
            if (equipment == null)
            {
                return Result.Fail("Equipment doesn't exist");
            }
            _context.Remove(equipment);
            _context.SaveChanges();
            return Result.Ok();
        }
    }
}
