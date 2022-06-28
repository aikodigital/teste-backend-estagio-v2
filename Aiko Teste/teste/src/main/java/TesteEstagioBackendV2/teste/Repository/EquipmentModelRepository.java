package TesteEstagioBackendV2.teste.Repository;

import TesteEstagioBackendV2.teste.Model.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, UUID> {
}
