package com.app.project.util;

import com.app.project.domain.EquipmentModel;
import com.app.project.requests.EquipmentModelPostRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class EquipmentModelCreator {

    public static EquipmentModel createEquipmentModelToBeSaved() {
        return EquipmentModel.builder()
                .name("130G")
                .build();
    }

    public static EquipmentModel createEquipmentModelValid() {
        return EquipmentModel.builder()
                .id(1L)
                .name("130G")
                .build();
    }
}
