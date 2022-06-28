package com.equipments.apirest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class EquipmentStateHistoryId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "equipment_id", foreignKey = @ForeignKey(name = "fk_equipment"))
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id", foreignKey = @ForeignKey(name = "fk_equipment_state"))
    private EquipmentState equipmentState;

}
