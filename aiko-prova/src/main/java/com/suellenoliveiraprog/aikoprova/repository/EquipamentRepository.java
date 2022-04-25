package com.suellenoliveiraprog.aikoprova.repository;

import java.util.UUID;
import com.suellenoliveiraprog.aikoprova.model.Equipament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentRepository extends JpaRepository<Equipament, UUID>{
    
}