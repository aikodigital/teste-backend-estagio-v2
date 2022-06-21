package io.github.pedrobicudo.testebackendestagiov2.rest.controller;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IEquipmentService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentUpdateDTO;
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

@Tag(name = "equipments endpoint")
@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    @Autowired
    private IEquipmentService service;

    @Operation(
            summary = "Return all equipments",
            responses = {
                    @ApiResponse(
                            description = "equipemnts return successfully",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(
                                            implementation = EquipmentDTO.class
                                    )
                                    )
                            )
                    )
            }
    )
    @GetMapping
    public List<EquipmentDTO> findAll() {
        return service.findAll();
    }

    @Operation(
            summary = "Return the equipment",
            responses = {
                    @ApiResponse(
                            description = "equipment has been found",
                            responseCode = "302",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = EquipmentDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "equipment with given id not found",
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
    public EquipmentDTO findById(
            @PathVariable("id") UUID id
    ) {
        return service.findById(id);
    }

    @Operation(
            summary = "Create an equipment",
            responses = {
                    @ApiResponse(
                            description = "equipment has been created",
                            responseCode = "201"
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @RequestBody @Valid EquipmentCreateDTO equipmentCreateDTO
    ) {
        service.create(equipmentCreateDTO);
    }

    @Operation(
            summary = "Update the equipment",
            responses = {
                    @ApiResponse(
                            description = "equipment has been updated",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "equipment with given id not found",
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
            @RequestBody @Valid EquipmentUpdateDTO equipmentUpdateDTO
    ) {
        service.update(id, equipmentUpdateDTO);
    }

    @Operation(
            summary = "Delete the equipment",
            responses = {
                    @ApiResponse(
                            description = "equipment has been deleted",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "equipment with given id not found",
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
        return new APIError("/equipments error: request body is invalid");
    }




}
