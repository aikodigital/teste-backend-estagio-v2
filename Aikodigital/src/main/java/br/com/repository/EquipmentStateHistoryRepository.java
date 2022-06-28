package br.com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.model.EquipmentStateHistoryEntity;

/**
 * Interface de repositório da classe EquipamentStateHistory que extende da interface JpaRepository
 * responsável pela camada de persistência 
 * @author Danillo Santiago
 * @since jun 2022
 */
@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistoryEntity, UUID> {

	/**
	 * Query de busca na tabela EquipmentPositionHistory que retorna o estado mais recente do equipamento no histórico
	 * @param equipamento ID
	 * @return Objeto da classe EquipmentStateHistory
	 */
	@Query(value = " select * from operation.equipment_state_history where date = (select max(date) from operation.equipment_state_history where equipment_id =?1) and equipment_id = ?1", nativeQuery = true)
	EquipmentStateHistoryEntity mostRecentlyState(UUID equipmentId);
}
