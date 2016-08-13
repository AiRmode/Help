package com.provectus.prodobro.dao;

public interface GenericDAO<T> {

    void create(T object);

    T read(int id);

    void update(T object);

    void delete(T object);
}
