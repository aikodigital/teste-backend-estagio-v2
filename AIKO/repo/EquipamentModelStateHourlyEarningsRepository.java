package com.suellenoliveiraprog.aikoprova.repository;

import com.suellenoliveiraprog.aikoprova.model.EquipamentModelStateHourlyEarnings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentModelStateHourlyEarningsRepository extends JpaRepository<EquipamentModelStateHourlyEarnings, Integer>{
    
}
