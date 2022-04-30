package com.aiko.aikodigital.repositoriesandservices;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiko.aikodigital.enties.Equipment_state;

public interface Equipment_stateRepository extends JpaRepository<Equipment_state, UUID>{

}
