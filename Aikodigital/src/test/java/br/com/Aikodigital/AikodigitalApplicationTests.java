package br.com.Aikodigital;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.DTO.EquipmentStateHistoryDTO;
import br.com.model.EquipmentEntity;
import br.com.model.EquipmentPositionHistoryEntity;
import br.com.model.EquipmentStateEntity;
import br.com.model.EquipmentStateHistoryEntity;
import br.com.repository.EquipmentPositionHistoryRepository;
import br.com.repository.EquipmentStateHistoryRepository;

@SpringBootTest
class AikodigitalApplicationTests {

	@Test
	void contextLoads() {
	}

	

	

	/**
	 * Teste unitário do método mostRecentlyPosition do repository EquipmentPositionHistoryRepository
	 * @author Danillo Santiago
	 * @since jun 2022
	 */
	@Test
	public void successfulStatus_WhenSelectMostRecentlyPositionIndividual() {
		EquipmentPositionHistoryRepository positionRepository = Mockito.mock(EquipmentPositionHistoryRepository.class);

		EquipmentPositionHistoryEntity positionHistoryEntity = new EquipmentPositionHistoryEntity();

		positionHistoryEntity.setLat(-19.1518F);
		positionHistoryEntity.setLon(-46.00776F);

		Mockito.when(positionRepository.mostRecentlyPosition(UUID.fromString("a7c53eb1-4f5e-4eba-9764-ad205d0891f9")))
				.thenReturn(positionHistoryEntity);

	}

	/**
	 * Teste unitário do método mostRecentlyState do repository EquipmentStateHistoryRepository
	 * @author Danillo Santiago
	 * @since jun 2022
	 */
	@Test
	public void successfulStatus_WhenSelectMostRecentlyStateIndividual() {
		EquipmentStateHistoryRepository stateRepository = Mockito.mock(EquipmentStateHistoryRepository.class);
		EquipmentStateHistoryEntity historyEntity = new EquipmentStateHistoryEntity();
		EquipmentEntity equipmentEntity = new EquipmentEntity();
		equipmentEntity.setId(UUID.fromString("a7c53eb1-4f5e-4eba-9764-ad205d0891f9"));
		historyEntity.setEquipment1(equipmentEntity);

		EquipmentStateEntity stateEntity = new EquipmentStateEntity();
		stateEntity.setId(UUID.fromString("0808344c-454b-4c36-89e8-d7687e692d57"));
		
		historyEntity.setEquipmentstate(stateEntity);
		EquipmentStateHistoryDTO stateHistoryEntity = new EquipmentStateHistoryDTO(historyEntity);

		Mockito.when(stateRepository.mostRecentlyState(UUID.fromString("a7c53eb1-4f5e-4eba-9764-ad205d0891f9")))
				.thenReturn(historyEntity);

	}

}
