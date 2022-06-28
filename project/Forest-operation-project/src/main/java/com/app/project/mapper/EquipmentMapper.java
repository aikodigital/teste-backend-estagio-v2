package com.app.project.mapper;

import com.app.project.domain.*;
import com.app.project.requests.equip.EquipPostRequest;
import com.app.project.requests.equip.EquipPutRequest;
import com.app.project.requests.equipModel.EquipmentModelPostRequest;
import com.app.project.requests.equipModel.EquipmentModelPutRequest;
import com.app.project.requests.equipPositionHistory.EquipPositionHistoryPostRequest;
import com.app.project.requests.equipState.EquipStatePostRequest;
import com.app.project.requests.equipState.EquipStatePutRequest;
import com.app.project.requests.equipStateHistory.EquipStateHistoryPostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EquipmentMapper {

    public static final EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    public abstract EquipmentModel toEquipment(EquipmentModelPostRequest postRequest);

    public abstract EquipmentModel toEquipment(EquipmentModelPutRequest putRequest);

    public abstract Equipment toEquipment(EquipPostRequest postRequest);

    public abstract Equipment toEquipment(EquipPutRequest putRequest);

    public abstract EquipmentState toEquipment(EquipStatePostRequest postRequest);

    public abstract EquipmentState toEquipment(EquipStatePutRequest poutRequest);

    public abstract EquipmentStateHistory toEquipment(EquipStateHistoryPostRequest postRequest);

}
