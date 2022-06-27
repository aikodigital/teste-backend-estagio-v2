package com.brunozarth.testeaiko.requests.equipmentPositionHistory;

import com.brunozarth.testeaiko.model.EquipmentPositionHistoryId;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class EquipmentPositionHistoryPutRequestBody {

    private EquipmentPositionHistoryId id;

    private UUID equipmentId;

    private Timestamp date;

    private float lat;

    private float lon;
}
