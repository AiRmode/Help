package com.provectus.prodobro.service;


import java.io.Serializable;
import java.util.List;

public interface GenericService<T, PK extends Serializable> {

	/**
     * Saved instance will receive actual id from DB
     *
     * @param object to save
     */
    void save(T object);

    T getById(PK id);

    void update(T object);

    void remove(T object);

    List<T> getAll();

}
