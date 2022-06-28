package br.com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.EquipmentModelEntity;

/**
 * Interface de repositório da classe EquipmentModel que extende da interface JpaRepository
 * responsável pela camada de persistência 
 * @author Danillo Santiago
 * @since jun 2022
 */
@Repository
public interface EquipmentModelRepository extends JpaRepository<EquipmentModelEntity, UUID> {

}
