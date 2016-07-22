package com.provectus.prodobro.info;


public class InfoImpl implements Info {

    private int id;
    private InfoType type;
    private String info;

    public InfoImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public InfoType getType() {
        return type;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setType(InfoType type) {
        this.type = type;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }
}
