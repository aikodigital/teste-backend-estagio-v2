package io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.StateHistory;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.StateHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface StateHistoryRepository extends JpaRepository<StateHistory, StateHistoryPK> {

    List<StateHistory> findByPk_equipment_id(UUID id);

    @Query(
            value = "select max(s.pk.date) from StateHistory s where s.pk.equipment.id = :equipment_id"
    )
    Date findMostRecentDateFromEquipment(@Param("equipment_id") UUID equipmentId);

}
