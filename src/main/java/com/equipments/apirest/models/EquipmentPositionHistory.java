package com.equipments.apirest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "equipment_position_history", schema = "operation")
public class EquipmentPositionHistory {

    @EmbeddedId
    private EquipmentPositionHistoryId equipmentPositionHistoryId;

    private LocalDate date;

    private Float lat;

    private Float lon;

}
