package io.github.pedrobicudo.testebackendestagiov2.rest.controller;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces.IHourlyEarningsService;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsUpdateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.position_history.PositionHistoryDTO;
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

@Tag(name = "hourly earnings endpoint")
@RestController
public class HourlyEarningsController {

    @Autowired
    private IHourlyEarningsService service;

    @Operation(
            summary = "Return hourly earnings from state",
            responses = {
                    @ApiResponse(
                            description = "hourly earnings return successfully",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema =
                                    @Schema(
                                            implementation = HourlyEarningsDTO.class
                                    )
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "state not found not found",
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
    @GetMapping("/states/{stateId}/hourly-earnings")
    public List<HourlyEarningsDTO> findAllFromState(
            @PathVariable("stateId") UUID stateId
    ) {
        return service.findAll(stateId);
    }

    @Operation(
            summary = "Return hourly earnings with given id",
            description = "hourly earnings id structure: stateId_modelId",
            responses = {
                    @ApiResponse(
                            description = "hourly earnings has been found",
                            responseCode = "302",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = HourlyEarningsDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "hourly earnings not found",
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
    @GetMapping("/hourly-earnings/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public HourlyEarningsDTO findById(
            @PathVariable("id") String id
    ) {
        return service.findById(id);
    }


    @Operation(
            summary = "Delete hourly earnings item",
            description = "hourly earnings id structure: stateId_modelId",
            responses = {
                    @ApiResponse(
                            description = "hourly earning has been deleted",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "hourly earning with given id not found",
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
    @DeleteMapping("/hourly-earnings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("id") String id
    ) {
        service.delete(id);
    }


    @Operation(
            summary = "Update hourly earnings item",
            description = "hourly earnings id structure: stateId_modelId",
            responses = {
                    @ApiResponse(
                            description = "hourly earnings has been updated",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "hourly earnings with given id not found",
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
    @PutMapping("/hourly-earnings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable("id") String id,
            @RequestBody @Valid HourlyEarningsUpdateDTO hourlyEarningsUpdateDTO
    ) {
        service.update(id, hourlyEarningsUpdateDTO);
    }

    @Operation(
            summary = "Create hourly earnings item",
            responses = {
                    @ApiResponse(
                            description = "hourly earnings item has been created",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "state or model not found",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = APIError.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            description = "hourly earnings with given already exists",
                            responseCode = "409",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = APIError.class
                                    )
                            )
                    )
            }
    )
    @PostMapping("/states/{stateId}/hourly-earnings")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @PathVariable("stateId") UUID stateId,
            @RequestBody @Valid HourlyEarningsCreateDTO hourlyEarningsCreateDTO
    ) {
        service.create(stateId, hourlyEarningsCreateDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIError handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return new APIError("/hourly-earnings error: request body is invalid");
    }

}
