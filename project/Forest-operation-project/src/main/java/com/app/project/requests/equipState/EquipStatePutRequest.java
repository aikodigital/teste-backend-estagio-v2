package com.app.project.requests.equipState;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipStatePutRequest {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String color;
}
