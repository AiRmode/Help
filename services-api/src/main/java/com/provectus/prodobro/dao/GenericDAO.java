package com.provectus.prodobro.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, PK extends Serializable> {

    void create(T object);

    T get(PK id);

    void update(T object);

    void remove(T object);

    List<T> getAll();
}
