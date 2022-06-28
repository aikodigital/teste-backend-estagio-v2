package com.equipments.apirest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class EquipmentPositionHistoryId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

}
