package com.aiko.testebackendestagiov2.services;

import java.util.List;
import java.util.UUID;

public interface ICrudService<T,U> {

    List<T> getAll();
    T getById(UUID id);
    T create(U request);
    T update(UUID id, U request);
    void delete(UUID id);
}
