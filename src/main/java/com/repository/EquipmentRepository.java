package com.repository;
import com.model.*;

//import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
  
  
  
}


