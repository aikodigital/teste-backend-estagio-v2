package TesteEstagioBackendV2.teste.Repository;

import TesteEstagioBackendV2.teste.Model.EquipmentPositionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EquipmentPositionHistoryRepository extends JpaRepository<EquipmentPositionHistory, UUID> {

    @Query(value = "SELECT DISTINCT ON(equipment_id) id, date,equipment_id,lat,lon from operation.equipment_position_history ORDER BY equipment_id, date DESC",nativeQuery = true)
    public Optional<List<EquipmentPositionHistory>> findMoreRecent();
}
