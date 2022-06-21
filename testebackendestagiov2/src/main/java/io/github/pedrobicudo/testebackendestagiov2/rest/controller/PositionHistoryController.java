package io.github.pedrobicudo.testebackendestagiov2.rest.controller;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IPositionHistoryService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.equipment.EquipmentDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryUpdateDTO;
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

@Tag(name = "positions history endpoint")
@RestController
public class PositionHistoryController {

    @Autowired
    private IPositionHistoryService service;

    @Operation(
            summary = "Return positions from equipment",
            responses = {
                    @ApiResponse(
                            description = "positions return successfully",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(
                                            implementation = PositionHistoryDTO.class
                                    )
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "equipment not found",
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
    @GetMapping("/equipments/{equipmentId}/positions-history")
    public List<PositionHistoryDTO> findAllFromEquipment(
        @PathVariable("equipmentId") UUID equipmentId
    ) {
        return service.findAll(equipmentId);
    }


    @Operation(
            summary = "Create position history item",
            responses = {
                    @ApiResponse(
                            description = "position history item has been created",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "equipment not found",
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
    @PostMapping("/equipments/{equipmentId}/positions-history")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @PathVariable("equipmentId") UUID equipmentId,
            @RequestBody @Valid PositionHistoryCreateDTO positionHistoryCreateDTO
    ) {
        service.create(equipmentId, positionHistoryCreateDTO);
    }


    @Operation(
            summary = "Return the current position from equipment",
            responses = {
                    @ApiResponse(
                            description = "most recent position found",
                            responseCode = "302",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = PositionHistoryDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "equipment not found",
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
    @GetMapping("/equipments/{equipmentId}/positions-history/current")
    @ResponseStatus(HttpStatus.FOUND)
    public PositionHistoryDTO findCurrentPosition(
            @PathVariable("equipmentId") UUID equipmentId
    ) {
        return service.current(equipmentId);
    }


    @Operation(
            summary = "Return position with given id",
            description = "position id structure: equipmentId_Date",
            responses = {
                    @ApiResponse(
                            description = "position has been found",
                            responseCode = "302",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = PositionHistoryDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "position not found",
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
    @GetMapping("/positions-history/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public PositionHistoryDTO findById(
            @PathVariable("id") String id
    ) {
        return service.findById(id);
    }


    @Operation(
            summary = "Delete position history item",
            description = "position id structure: equipmentId_Date",
            responses = {
                    @ApiResponse(
                            description = "position has been deleted",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "position with given id not found",
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
    @DeleteMapping("/positions-history/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id") String id
    ){
        service.delete(id);
    }

    @Operation(
            summary = "Update position history item",
            description = "position id structure: equipmentId_Date",
            responses = {
                    @ApiResponse(
                            description = "position has been updated",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "position with given id not found",
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
    @PutMapping("/positions-history/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable("id") String id,
            @RequestBody @Valid PositionHistoryUpdateDTO positionHistoryUpdateDTO
    ){
        service.update(id, positionHistoryUpdateDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIError handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return new APIError("/positions-history error: request body is invalid");
    }

}
