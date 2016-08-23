package com.provectus.prodobro.service;


import java.io.Serializable;
import java.util.List;

public interface GenericService<T, PK extends Serializable> {

    void save(T object);

    T getById(PK id);

    void update(T object);

    void remove(T object);

    List<T> getAll();

}
