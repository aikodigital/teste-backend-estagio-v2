﻿using Api.Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.Entities
{
    public class EquipmentPositionHistoryEntity : BaseEntity
    {
        public DateTime Date { get; set; }
        public float Lat { get; set; }
        public float Lon { get; set; }
        public Guid EquipmentId { get; set; }
        public virtual EquipmentEntity Equipment { get; set; }
    }
}
