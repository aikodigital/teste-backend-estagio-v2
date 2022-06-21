package io.github.pedrobicudo.testebackendestagiov2.rest.controller;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IEquipmentStateService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment_state.EquipmentStateUpdateDTO;
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

@Tag(name = "states endpoint")
@RestController
@RequestMapping("/states")
public class EquipmentStateController {

    @Autowired
    private IEquipmentStateService service;

    @Operation(
            summary = "Return all equipment states",
            responses = {
                    @ApiResponse(
                            description = "States return successfully",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(
                                            implementation = EquipmentStateDTO.class
                                    )
                                    )
                            )
                    )
            }
    )
    @GetMapping
    public List<EquipmentStateDTO> findAll() {
        return service.findAll();
    }

    @Operation(
            summary = "Return the equipment state",
            responses = {
                    @ApiResponse(
                            description = "State has been found",
                            responseCode = "302",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = EquipmentStateDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "State with given id not found",
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
    public EquipmentStateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }

    @Operation(
            summary = "Create an equipment state",
            responses = {
                    @ApiResponse(
                            description = "State has been created",
                            responseCode = "201"
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
        @RequestBody @Valid EquipmentStateCreateDTO equipmentStateCreateDTO
    ) {
        service.create(equipmentStateCreateDTO);
    }


    @Operation(
            summary = "Update the equipment state",
            responses = {
                    @ApiResponse(
                            description = "State has been updated",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "State with given id not found",
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
            @RequestBody @Valid EquipmentStateUpdateDTO equipmentStateUpdateDTO
    ) {
        service.update(id, equipmentStateUpdateDTO);
    }

    @Operation(
            summary = "Delete the equipment state",
            responses = {
                    @ApiResponse(
                            description = "State has been deleted",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "State with given id not found",
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
        return new APIError("/states error: request body is invalid");
    }

}
