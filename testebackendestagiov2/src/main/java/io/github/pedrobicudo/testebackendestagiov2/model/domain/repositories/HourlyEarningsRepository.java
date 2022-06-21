package io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.HourlyEarnings;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.HourlyEarningsPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HourlyEarningsRepository extends JpaRepository<HourlyEarnings, HourlyEarningsPK> {
    List<HourlyEarnings> findByPk_state_id(UUID stateId);
}
