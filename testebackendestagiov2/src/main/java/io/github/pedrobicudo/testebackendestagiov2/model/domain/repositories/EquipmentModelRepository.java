package io.github.pedrobicudo.testebackendestagiov2.model.domain.repositories;

import io.github.pedrobicudo.testebackendestagiov2.model.domain.entities.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {
}
