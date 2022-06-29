package com.app.project.requests.equipStateHistory;

import com.app.project.domain.Equipment;
import com.app.project.domain.EquipmentState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipStateHistoryPutRequest {

    @NotNull
    private UUID id;

    @NotBlank
    private LocalDateTime date;

    @NotNull
    private Equipment equipment;

    @NotNull
    private EquipmentState equipmentState;
}
