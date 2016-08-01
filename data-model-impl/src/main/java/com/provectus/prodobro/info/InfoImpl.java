package com.provectus.prodobro.info;


public class InfoImpl implements Info {

    private int id;
    private InfoType type;
    private String info;

    public InfoImpl() {
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
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setType(InfoType type) {
        this.type = type;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InfoImpl)) return false;

        InfoImpl info1 = (InfoImpl) o;

        if (type != info1.type) return false;
        return info.equals(info1.info);

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + info.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "InfoImpl{" +
                "id=" + id +
                ", type=" + type +
                ", info='" + info + '\'' +
                '}';
    }
}
