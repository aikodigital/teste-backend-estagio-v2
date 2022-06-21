package io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.Equipment;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentDTO {
    private String id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EquipmentModelDTO model;

    public EquipmentDTO(Equipment equipment) {
        this.id = equipment.getId().toString();
        this.name = equipment.getName();
        this.model = new EquipmentModelDTO(equipment.getEquipmentModel());
    }
}
