package io.github.humbertoluiz.domain.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import io.github.humbertoluiz.domain.entity.EquipmentModel;

@Repository
public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID>{

	@Query(" select m from EquipmentModel m left join fetch m.equipment where m.id = :id ")
	EquipmentModel findEquipmentModelFetchEquipment( @Param("id") UUID id );

}

