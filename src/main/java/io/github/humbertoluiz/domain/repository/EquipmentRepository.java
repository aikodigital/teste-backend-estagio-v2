package io.github.humbertoluiz.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.domain.entity.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, UUID>{

	@Query(" select e from Equipment e left join fetch e.equipmentStateHistory where e.id = :id ")
	Equipment findEquipmentFetchEquipmentStateHistory( @Param("id") UUID id );
	
	@Query(" select e from Equipment e left join fetch e.equipmentPositionHistory where e.id = :id ")
	Equipment findEquipmentFetchEquipmentPositionHistory( @Param("id") UUID id );
}
