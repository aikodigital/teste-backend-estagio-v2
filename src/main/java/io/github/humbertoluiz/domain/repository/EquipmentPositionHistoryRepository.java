package io.github.humbertoluiz.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.domain.entity.EquipmentPositionHistory;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, UUID>{

}
