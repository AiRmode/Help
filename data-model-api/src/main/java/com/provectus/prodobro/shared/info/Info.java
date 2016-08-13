package com.provectus.prodobro.shared.info;


public interface Info<T> {

    int getId();

    T getOwner();

    String getInfo();

    String getType();

    void setId(int id);

    void setOwner(T owner);

    void setInfo(String info);

    void setType(String type);

}
