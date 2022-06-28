package com.app.project.requests.equipModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentModelPutRequest {

    @NotNull
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String name;
}
