package com.app.project.requests.equip;

import com.app.project.domain.EquipmentModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipPutRequest {

    @NotNull
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private EquipmentModel model;
}
