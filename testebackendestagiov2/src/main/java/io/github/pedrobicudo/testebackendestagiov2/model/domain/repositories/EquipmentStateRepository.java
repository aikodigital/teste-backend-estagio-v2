package io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID> {
}
