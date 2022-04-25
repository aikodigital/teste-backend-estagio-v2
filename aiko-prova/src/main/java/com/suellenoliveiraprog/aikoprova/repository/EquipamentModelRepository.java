package com.suellenoliveiraprog.aikoprova.repository;

import java.util.UUID;
import com.suellenoliveiraprog.aikoprova.model.EquipamentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentModelRepository extends JpaRepository<EquipamentModel, UUID>{
    
}
