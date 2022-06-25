package com.app.project.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class EquipmentModelPostRequest {

    @NotBlank
    private String name;
}
