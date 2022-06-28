package br.com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.model.EquipmentPositionHistoryEntity;

/**
 * Interface de repositório da classe EquipmentPositionHistory que extende da interface JpaRepository
 * responsável pela camada de persistência 
 * @author Danillo Santiago
 * @since jun 2022
 */
@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistoryEntity, UUID> {

	/**
	 * Query de busca na tabela EquipmentPositionHistory que retorna a posição mais recente do equipamento no histórico
	 * @param equipamento id
	 * @return Objeto da classe EquipmentPositionHistory
	 */
	@Query(value = "select * from operation.equipment_position_history where date = (select max(date) from operation.equipment_position_history where equipment_id =?1) and equipment_id = ?1", nativeQuery = true)
	EquipmentPositionHistoryEntity mostRecentlyPosition(UUID id);
}
