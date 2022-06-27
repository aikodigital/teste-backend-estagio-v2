package com.brunozarth.testeaiko.requests.equipmentStateHistory;

import com.brunozarth.testeaiko.model.EquipmentStateHistoryId;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class EquipmentStateHistoryPostRequestBody {

    private EquipmentStateHistoryId id;

    private UUID equipmentId;

    private Timestamp date;

    private UUID equipmentStateId;
}
