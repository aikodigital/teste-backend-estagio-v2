package com.app.project.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentModelPostRequest {

    @NotBlank
    @Column(nullable = false)
    private String name;
}
