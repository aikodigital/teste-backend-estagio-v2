package com.app.project.requests.equipStateHistory;

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
public class EquipStateHistoryPostRequest {

    @NotNull
    private UUID equipmentId;

    @NotNull
    private UUID equipmentStateId;
}
