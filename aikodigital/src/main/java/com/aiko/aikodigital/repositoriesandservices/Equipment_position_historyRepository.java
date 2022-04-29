package com.aiko.aikodigital.repositoriesandservices;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aiko.aikodigital.enties.Equipment_position_history;

public interface Equipment_position_historyRepository  extends JpaRepository<Equipment_position_history, UUID>{

}
