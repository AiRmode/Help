package com.provectus.prodobro.shared.info;


public interface Info<T> {

    Long getId();

    T getOwner();

    String getInfo();

    String getType();

    void setId(Long id);

    void setOwner(T owner);

    void setInfo(String info);

    void setType(String type);

}
