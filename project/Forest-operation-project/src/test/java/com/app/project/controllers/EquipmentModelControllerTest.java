package com.app.project.controllers;

import com.app.project.domain.EquipmentModel;
import com.app.project.exceptions.NotFoundException;
import com.app.project.requests.equipModel.EquipmentModelPostRequest;
import com.app.project.requests.equipModel.EquipmentModelPutRequest;
import com.app.project.services.EquipmentModelService;
import com.app.project.util.equipModel.EquipmentModelCreator;
import com.app.project.util.equipModel.EquipmentModelPostRequestCreator;
import com.app.project.util.equipModel.EquipmentModelPutRequestCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class EquipmentModelControllerTest {

    final static UUID UUID_VALID = UUID.fromString("2c616b33-c9f1-4300-a97d-e429ec0c0825");

    @InjectMocks
    private EquipmentModelController modelController;

    @Mock
    private EquipmentModelService modelService;

    @BeforeEach
    void setUp() throws NotFoundException {
        BDDMockito.when(modelService.save(ArgumentMatchers.any(EquipmentModelPostRequest.class)))
                .thenReturn(EquipmentModelCreator.createEquipmentModelValid());

        BDDMockito.when(modelService.findAll())
                .thenReturn(List.of(EquipmentModelCreator.createEquipmentModelValid()));

        BDDMockito.when(modelService.findByIdOrThrowNotFoundException(ArgumentMatchers.any(UUID.class)))
                .thenReturn(EquipmentModelCreator.createEquipmentModelValid());

        BDDMockito.doNothing().when(modelService).update(ArgumentMatchers.any(EquipmentModelPutRequest.class));

        BDDMockito.doNothing().when(modelService).delete(ArgumentMatchers.any(UUID.class));
    }

    @Test
    @DisplayName("listAll returns a list of equipment models when successful")
    void listAll_ReturnsAListOfEquipmentModels_WhenSuccessful() {
        String expectedName = EquipmentModelCreator.createEquipmentModelValid().getName();

        List<EquipmentModel> equipModels = modelController.listAll().getBody();

        Assertions.assertThat(equipModels)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(equipModels.get(0).getName()).isEqualTo(expectedName);

    }

    @Test
    @DisplayName("findById returns an equipment model when successful")
    void findById_ReturnsAnEquipmentModel_WhenSuccessful() throws NotFoundException {
        UUID expectedId = EquipmentModelCreator.createEquipmentModelValid().getId();

        EquipmentModel equipmentModel = modelController.getById(UUID_VALID).getBody();

        Assertions.assertThat(equipmentModel).isNotNull();

        Assertions.assertThat(equipmentModel.getId()).isNotNull().
                isEqualTo(expectedId);
    }

    @Test
    @DisplayName("post returns an equipment model when successful")
    void post_ReturnsAnEquipmentModel_WhenSuccessful() {

        EquipmentModel post = modelController.post(
                EquipmentModelPostRequestCreator.createEquipmentModelPostRequestBody()).getBody();

        Assertions.assertThat(post)
                .isNotNull()
                .isEqualTo(EquipmentModelCreator.createEquipmentModelValid());
    }

    @Test
    @DisplayName("put updates an equipment model when successful")
    void put_UpdatesAnEquipmentModel_WhenSuccessful() throws NotFoundException {

        Assertions.assertThatCode(() -> modelController.put(
                        EquipmentModelPutRequestCreator.createEquipmentModelPutRequestBody()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> updatedEquipModel = modelController.put(
                EquipmentModelPutRequestCreator.createEquipmentModelPutRequestBody());

        Assertions.assertThat(updatedEquipModel).isNotNull();

        Assertions.assertThat(updatedEquipModel.getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("delete removes an equipment model when successful")
    void delete_RemovesAnEquipmentModelWhenSuccessful() throws NotFoundException {
        Assertions.assertThatCode(() -> modelController.delete(
                        EquipmentModelCreator.createEquipmentModelValid().getId()))
                .doesNotThrowAnyException();

        ResponseEntity<Void> equipModel = modelController.delete(UUID_VALID);

        Assertions.assertThat(equipModel).isNotNull();
        Assertions.assertThat(equipModel.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}