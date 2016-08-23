package com.provectus.prodobro.shared.avatar;


public interface Avatar {

    Long getId();

    byte[] getBytea();

    void setId(Long id);

    void setBytea(byte[] bytea);
}
