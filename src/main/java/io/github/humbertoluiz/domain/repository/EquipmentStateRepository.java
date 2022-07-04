package io.github.humbertoluiz.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.humbertoluiz.domain.entity.EquipmentState;

@Repository
public interface EquipmentStateRepository extends JpaRepository<EquipmentState, UUID>{

	@Query(" select s from EquipmentState s left join fetch s.equipmentStateHistory where s.id = :id ")
	EquipmentState findEquipmentStateFetchEquipmentStateHistory( @Param("id") UUID id );
	
	@Query(" select e from EquipmentState e left join fetch e.equipmentModelStateHourlyEarnings where e.id = :id ")
	EquipmentState findEquipmentStateFetchEquipmentModelStateHourlyEarnings( @Param("id") UUID id );
	
}
