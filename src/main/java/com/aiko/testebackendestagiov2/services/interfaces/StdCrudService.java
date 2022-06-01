package com.aiko.testebackendestagiov2.services.interfaces;

import java.util.List;

public interface StdCrudService<T,I> {
 
    public List<T> findAll();
    public T save(T obj);
    public T findById(I id);
    public T update(I id, T obj);
    public void deleteById(I id);

}