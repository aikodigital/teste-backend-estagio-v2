package com.aiko.apicrud.models;

/**
 *
 * @author Celso França Neto
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_model_state_hourly_earnings", schema = "operation")
@IdClass(ModelStateId.class)
public class EquipmentModelStateHourlyEarnings implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(nullable = false, name = "equipment_model_id", foreignKey = @ForeignKey(name = "fk_equipment_model"))
    private EquipmentModel equipmentModel;

    @Id
    @ManyToOne
    @JoinColumn(name = "equipment_state_id")
    private EquipmentState equipmentState;

    @Column(name = "value")
    private Double value;

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public Double getValue() {
        return this.value;
    }

}
