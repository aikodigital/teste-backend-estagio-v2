package com.aikoprocesso.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aikoprocesso.api.model.Equipment_position_history;

public interface Equipment_position_historyRepository extends JpaRepository<Equipment_position_history, UUID> {

}
