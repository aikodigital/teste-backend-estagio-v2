package com.br.raf.equipments.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "equipment_state_history")
public class EquipmentStateHistory  {

    @Column(name = "equipment_id")
    private UUID equipmentId;

    @Id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @Column(name = "equipment_state_id")
    private UUID equipmentStateId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentStateHistory that = (EquipmentStateHistory) o;
        return equipmentId.equals(that.equipmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId);
    }

    @Override
    public String toString() {
        return "equipmentId = " + equipmentId + ", date = " + date + ", Equipment state id"+ equipmentStateId;
    }


}


