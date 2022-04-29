package com.aiko.aikodigital.repositoriesandservices;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiko.aikodigital.enties.Equipment_state_history;

public interface Equipment_state_historyRepository extends JpaRepository<Equipment_state_history, UUID>{

}
