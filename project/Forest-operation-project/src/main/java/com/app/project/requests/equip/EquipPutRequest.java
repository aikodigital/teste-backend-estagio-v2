package com.app.project.requests.equip;

import com.app.project.domain.EquipmentModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipPutRequest {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private EquipmentModel model;
}
