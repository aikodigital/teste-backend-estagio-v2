package com.app.project.requests.equipPositionHistory;

import com.app.project.domain.Equipment;
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
public class EquipPositionHistoryPostRequest {

    @NotNull
    private UUID equipment;

    @NotBlank
    @NotNull
    private BigDecimal lat;

    @NotBlank
    @NotNull
    private BigDecimal lon;
}
