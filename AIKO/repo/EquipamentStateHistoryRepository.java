package com.suellenoliveiraprog.aikoprova.repository;

import com.suellenoliveiraprog.aikoprova.model.EquipamentStateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentStateHistoryRepository extends JpaRepository<EquipamentStateHistory, Integer>{
    
}
