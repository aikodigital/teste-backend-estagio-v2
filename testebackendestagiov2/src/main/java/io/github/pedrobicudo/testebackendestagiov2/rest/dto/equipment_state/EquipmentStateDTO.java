package io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentStateDTO {
    private String id;
    private String name;
    private String color;

    public EquipmentStateDTO(EquipmentState equipmentState) {
        this.id = equipmentState.getId().toString();
        this.name = equipmentState.getName();
        this.color = equipmentState.getColor();
    }
}
