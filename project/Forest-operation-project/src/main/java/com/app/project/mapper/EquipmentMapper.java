package com.app.project.mapper;

import com.app.project.domain.EquipmentModel;
import com.app.project.requests.EquipmentModelPostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EquipmentMapper {

    public static final EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    public abstract EquipmentModel toEquipmentModel(EquipmentModelPostRequest equipmentModelPostRequest);
}
