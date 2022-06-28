package com.app.project.requests.equipModelStateHourlyEarnings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipModelStateHourlyEarningsPostRequest {

    @NotBlank
    private UUID equipmentModelId;

    @NotBlank
    private UUID equipmentStateId;

    @NotNull
    private BigDecimal value;
}
