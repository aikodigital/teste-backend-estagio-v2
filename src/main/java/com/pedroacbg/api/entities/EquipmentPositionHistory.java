package com.pedroacbg.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pedroacbg.api.pk.EquipmentPositionHistoryPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "equipment_position_history", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentPositionHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EquipmentPositionHistoryPK id = new EquipmentPositionHistoryPK();

    @NotNull
    private Float lat;

    @NotNull
    private Float lon;
}
