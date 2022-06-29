package com.app.project.requests.equipState;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipStatePostRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String color;
}
