package TesteEstagioBackendV2.teste.Repository;

import TesteEstagioBackendV2.teste.Model.EquipmentStateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EquipmentStateHistoryRepository extends JpaRepository<EquipmentStateHistory, UUID> {

    @Query(value = "SELECT DISTINCT ON(equipment_id) id, date, equipment_state_id,equipment_id from operation.equipment_state_history ORDER BY equipment_id, date DESC",nativeQuery = true)
    Optional<List<EquipmentStateHistory>> findMoreRecent();
}
