package io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.PositionHistory;
import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.PositionHistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PositionHistoryRepository extends JpaRepository<PositionHistory, PositionHistoryPK> {
    List<PositionHistory> findByPk_equipment_id(UUID id);

    @Query(
            value = "select max(p.pk.date) from PositionHistory p where p.pk.equipment.id = :equipment_id"
    )
    Date findByRecentDateFromEquipment(@Param("equipment_id") UUID equipmentId);
}
