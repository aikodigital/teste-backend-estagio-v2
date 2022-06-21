package io.github.pedrobicudo.testebackendestagiov2.rest.controller;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IStateHistoryService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.state_history.StateHistoryUpdateDTO;
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

@Tag(name = "state history endpoint")
@RestController
public class StateHistoryController {

    @Autowired
    private IStateHistoryService service;

    @Operation(
            summary = "Return state history from equipment",
            responses = {
                    @ApiResponse(
                            description = "state history return successfully",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(
                                            implementation = StateHistoryDTO.class
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
    @GetMapping("/equipments/{equipmentId}/states-history")
    public List<StateHistoryDTO> findAll(
            @PathVariable("equipmentId") UUID equipmentId
    ) {
        return service.findAll(equipmentId);
    }

    @Operation(
            summary = "Return the current state from equipment",
            responses = {
                    @ApiResponse(
                            description = "current state found",
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
    @GetMapping("/equipments/{equipmentId}/states-history/current")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StateHistoryDTO current(
            @PathVariable("equipmentId") UUID equipmentId
    ) {
        return service.current(equipmentId);
    }

    @Operation(
            summary = "Return state with given id",
            description = "state id structure: equipmentId_Date",
            responses = {
                    @ApiResponse(
                            description = "state has been found",
                            responseCode = "302",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = StateHistoryDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "state not found",
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
    @GetMapping("/states-history/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public StateHistoryDTO findById(
            @PathVariable("id") String id
    ) {
        return service.findById(id);
    }

    @Operation(
            summary = "Delete state history item",
            description = "position id structure: equipmentId_Date",
            responses = {
                    @ApiResponse(
                            description = "state has been deleted",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "state with given id not found",
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
    @DeleteMapping("/states-history/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id") String id
    ) {
        service.delete(id);
    }

    @Operation(
            summary = "Create state history item",
            responses = {
                    @ApiResponse(
                            description = "state history item has been created",
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
    @PostMapping("/equipments/{equipmentId}/states-history")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @PathVariable("equipmentId") UUID equipmentId,
            @RequestBody @Valid StateHistoryCreateDTO stateHistoryCreate
    ) {
        service.create(equipmentId, stateHistoryCreate);
    }

    @Operation(
            summary = "Update state history item",
            description = "state id structure: equipmentId_Date",
            responses = {
                    @ApiResponse(
                            description = "state has been updated",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "state with given id not found",
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
    @PutMapping("/states-history/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable("id") String id,
            @RequestBody @Valid StateHistoryUpdateDTO stateHistoryUpdate
    ) {
        service.update(id, stateHistoryUpdate);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIError handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return new APIError("/states-history error: request body is invalid");
    }

}
