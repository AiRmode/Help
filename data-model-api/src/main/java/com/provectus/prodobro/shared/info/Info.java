package com.provectus.prodobro.shared.info;


public interface Info<T> {

    Long getId();

    void setId(Long id);

    T getOwner();

    void setOwner(T owner);

    String getInfo();

    void setInfo(String info);

    String getType();

    void setType(String type);

}
