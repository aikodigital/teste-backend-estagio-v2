package io.github.humbertoluiz.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.domain.entity.EquipmentStateHistory;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, UUID>{

}
