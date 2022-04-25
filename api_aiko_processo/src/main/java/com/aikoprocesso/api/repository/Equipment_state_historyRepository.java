package com.aikoprocesso.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.aikoprocesso.api.model.Equipment_state_history;

public interface Equipment_state_historyRepository  extends JpaRepository<Equipment_state_history, UUID>{

}
