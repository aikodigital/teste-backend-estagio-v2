package io.github.pedrobicudo.testebackendestagiov2.model.domain.services.interfaces;

import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsCreateDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsDTO;
import io.github.pedrobicudo.testebackendestagiov2.rest.dto.hourly_earnings.HourlyEarningsUpdateDTO;

import java.util.List;
import java.util.UUID;

public interface IHourlyEarningsService {
    List<HourlyEarningsDTO> findAll(UUID stateId);
    boolean isHourlyEarningsIdValid(String hourlyEarningsId);
    HourlyEarningsDTO findById(String hourlyEarningsId);
    void delete(String hourlyEarningsId);
    void create(UUID stateId, HourlyEarningsCreateDTO hourlyEarningsCreate);
    void update(String hourlyEarningsId, HourlyEarningsUpdateDTO hourlyEarningsUpdate);
}
