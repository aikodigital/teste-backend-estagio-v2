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

@ExtendWith(SpringExtension.class)
class EquipmentModelControllerTest {

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

        BDDMockito.when(modelService.findByIdOrThrowNotFoundException(ArgumentMatchers.anyLong()))
                .thenReturn(EquipmentModelCreator.createEquipmentModelValid());

        BDDMockito.doNothing().when(modelService).update(ArgumentMatchers.any(EquipmentModelPutRequest.class));

        BDDMockito.doNothing().when(modelService).delete(ArgumentMatchers.anyLong());
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
        Long expectedId = EquipmentModelCreator.createEquipmentModelValid().getId();

        EquipmentModel equipmentModel = modelController.getById(1L).getBody();

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

        ResponseEntity<Void> equipModel = modelController.delete(1l);

        Assertions.assertThat(equipModel).isNotNull();
        Assertions.assertThat(equipModel.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}