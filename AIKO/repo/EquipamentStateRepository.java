package com.suellenoliveiraprog.aikoprova.repository;

import com.suellenoliveiraprog.aikoprova.model.EquipamentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentStateRepository extends JpaRepository<EquipamentState, Integer>{
    
}
