package com.provectus.prodobro.additional.info;


public interface Info<T> {

    int getId();

    T getOwner();

    String getInfo();

    InfoType getType();

    void setId(int id);

    void setOwner(T owner);

    void setInfo(String info);

    void setType(InfoType type);

}
