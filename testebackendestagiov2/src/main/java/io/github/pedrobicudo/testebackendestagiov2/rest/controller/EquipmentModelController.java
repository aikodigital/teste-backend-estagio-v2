package io.github.pedrobicudo.testebackendestagiov2.rest.controller;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IEquipmentModelService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_model.EquipmentModelUpdateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.error.APIError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "models endpoint")
@RestController
@RequestMapping("/models")
public class EquipmentModelController {

    @Autowired
    private IEquipmentModelService service;

    @Operation(
            summary = "Return all equipment models",
            responses = {
                    @ApiResponse(
                            description = "Models return successfully",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(
                                            implementation = EquipmentModelDTO.class
                                    )
                                    )
                            )
                    )
            }
    )
    @GetMapping
    public List<EquipmentModelDTO> findAll() {
        return service.findAll();
    }

    @Operation(
            summary = "Return the equipment model",
            responses = {
                    @ApiResponse(
                            description = "model has been found",
                            responseCode = "302",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = EquipmentModelDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "model with given id not found",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = APIError.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public EquipmentModelDTO findById(
            @PathVariable("id") UUID id
    ) {
        return service.findById(id);
    }

    @Operation(
            summary = "Create an equipment model",
            responses = {
                    @ApiResponse(
                            description = "model has been created",
                            responseCode = "201"
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @RequestBody @Valid EquipmentModelCreateDTO equipmentModelCreateDTO
    ) {
        service.create(equipmentModelCreateDTO);
    }

    @Operation(
            summary = "Update the equipment model",
            responses = {
                    @ApiResponse(
                            description = "model has been updated",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "model with given id not found",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = APIError.class
                                    )
                            )
                    )
            }
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable("id") UUID id,
            @RequestBody @Valid EquipmentModelUpdateDTO equipmentModelUpdateDTO
    ) {
        service.update(id, equipmentModelUpdateDTO);
    }

    @Operation(
            summary = "Delete the equipment model",
            responses = {
                    @ApiResponse(
                            description = "model has been deleted",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "model with given id not found",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = APIError.class
                                    )
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id") UUID id
    ) {
        service.delete(id);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIError handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return new APIError("/models error: request body is invalid");
    }

}
