package com.suellenoliveiraprog.aikoprova.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/* O histórico de estados por equipamento. */

@Entity
public class EquipamentStateHistory {
    
    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Integer equipament_id; //Chave estrangeira, utilizada para referenciar de qual equipamento é esse estado.
    private Date date; //Data em que o equipamento declarou estar nesse estado.
    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Integer equipament_state_id; //Chave estrangeira, utilizada para referenciar qual é o estado que o equipamento estava nesse momento.
    
    public Integer getEquipament_id() {
        return equipament_id;
    }
    
    public void setEquipament_id(Integer equipament_id) {
        this.equipament_id = equipament_id;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Integer getEquipament_state_id() {
        return equipament_state_id;
    }
    
    public void setEquipament_state_id(Integer equipament_state_id) {
        this.equipament_state_id = equipament_state_id;
    }

}
