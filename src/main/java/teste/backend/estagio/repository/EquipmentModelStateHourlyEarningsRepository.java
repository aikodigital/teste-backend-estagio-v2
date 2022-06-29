package teste.backend.estagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import teste.backend.estagio.entities.EquipmentModelStateHourlyEarnings;
import teste.backend.estagio.entities.pk.EquipmentModelStateHourlyEarningsPk;

@Repository
public interface EquipmentModelStateHourlyEarningsRepository extends JpaRepository<EquipmentModelStateHourlyEarnings, EquipmentModelStateHourlyEarningsPk>{


}
