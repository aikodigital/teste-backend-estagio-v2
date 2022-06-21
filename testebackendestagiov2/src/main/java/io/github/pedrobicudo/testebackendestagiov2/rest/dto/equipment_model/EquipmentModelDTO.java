package io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentModelDTO {
    private String id;
    private String name;

    public EquipmentModelDTO(EquipmentModel equipmentModel) {
        this.id = equipmentModel.getId().toString();
        this.name = equipmentModel.getName();
    }
}
