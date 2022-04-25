package com.suellenoliveiraprog.aikoprova.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

/* Informação de qual é o valor por hora do modelo de equipamento em cada um dos estados. */

@Entity
public class EquipamentModelStateHourlyEarnings {
    
    @ManyToMany 
    @JoinColumn(nullable = false)
    private Integer equipament_model_id; //Chave estrangeira, utilizada para referenciar de qual modelo é esse valor.
    @ManyToMany 
    @JoinColumn(nullable = false)
    private String equipment_state_id; //Chave estrangeira, utilizada para referenciar de qual valor é esse estado.
    private Double value; //Valor gerado por hora nesse estado.

    public Integer getEquipament_model_id() {
        return equipament_model_id;
    }

    public void setEquipament_model_id(Integer equipament_model_id) {
        this.equipament_model_id = equipament_model_id;
    }

    public String getEquipment_state_id() {
        return equipment_state_id;
    }

    public void setEquipment_state_id(String equipment_state_id) {
        this.equipment_state_id = equipment_state_id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
