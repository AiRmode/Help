package com.provectus.prodobro.info;


public interface Info {

    int getId();

    InfoType getType();

    String getInfo();

    void setId(int id);

    void setType(InfoType type);

    void setInfo(String info);

}
