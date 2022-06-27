package com.estagio.aiko.equipments.api.infrastructure.persistence.repository.shared;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

}
