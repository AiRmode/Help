package com.provectus.prodobro.info;


public interface Info {

    int getId();

    InfoType getType();

    String getInfo();

    void setType(InfoType type);

    void setInfo(String info);

}
