package com.pedroacbg.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedroacbg.api.pk.EquipmentStateHistoryPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "equipment_state_history", schema = "operation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentStateHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EquipmentStateHistoryPK id = new EquipmentStateHistoryPK();

}
