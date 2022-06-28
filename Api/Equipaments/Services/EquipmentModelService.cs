using AutoMapper;
using Equipments.Data;
using Equipments.Models;
using Equipments.Data.Dtos.Equipment;
using FluentResults;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Equipments.Services
{
    public class EquipmentModelService
    {
        private IMapper _mapper;
        private AppDbContext _context;
       
        public EquipmentModelService(IMapper mapper, AppDbContext context)
        {
            _mapper = mapper;
            _context = context;
        }

        public ReadEquipmentModelDto AddEquipmentModel(CreateEquipmentModelDto equipmentModelDto)
        {
            Equipment_Model equipmentModel = _mapper.Map<Equipment_Model>(equipmentModelDto);
            _context.equipment_model.Add(equipmentModel);
            _context.SaveChanges();
            return _mapper.Map<ReadEquipmentModelDto>(equipmentModel);
        }


        public List<ReadEquipmentModelDto> GetEquipmentModel(string equipmentModelName)
        {
            List<Equipment_Model> equipments = _context.equipment_model.ToList();
            if (equipments == null)
            {
                return null;
            }
            if (!string.IsNullOrEmpty(equipmentModelName))
            {
                IEnumerable<Equipment_Model> query = from equipment in equipments
                                               where equipment.name.Contains(equipmentModelName, StringComparison.InvariantCultureIgnoreCase)
                                               select equipment;

                equipments = query.ToList();
            }

            return _mapper.Map<List<ReadEquipmentModelDto>>(equipments);
        }

        /*[HttpGet]
        public IActionResult RecuperaLastEquipment()
        {
            ReadEquipmentDto equipmentDto = _mapper.Map<ReadEquipmentDto>(_context.equipment.ToList().Last());
            return Ok(equipmentDto);
        }*/


        public ReadEquipmentModelDto GetEquipmentModelById(Guid id)
        {
            Equipment_Model equipment_model = _context.equipment_model.FirstOrDefault(equipmentModel => equipmentModel.id == id);
            if (equipment_model != null)
            {
                ReadEquipmentModelDto equipmentModelDto = _mapper.Map<ReadEquipmentModelDto>(equipment_model);
                return equipmentModelDto;
            }
            return null;
        }

        public Result UpdateEquipmentModel(Guid id, UpdateEquipmentModelDto equipmentDto)
        {
            Equipment equipment = _context.equipment.FirstOrDefault(equipment => equipment.id == id);
            if (equipment == null)
            {
                return Result.Fail("Equipment Model doesn't exist");
            }
            _mapper.Map(equipmentDto, equipment);
            _context.SaveChanges();
            return Result.Ok();
        }

        public Result DeleteEquipmentModel(Guid id)
        {
            Equipment equipment = _context.equipment.FirstOrDefault(equipment => equipment.id == id);
            if (equipment == null)
            {
                return Result.Fail("Equipment Model doesn't exist");
            }
            _context.Remove(equipment);
            _context.SaveChanges();
            return Result.Ok();
        }
    }
}
