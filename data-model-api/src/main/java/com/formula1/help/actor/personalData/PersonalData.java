package com.formula1.help.actor.personalData;

/**
 * Created by alexey on 28.05.16.
 */
public interface PersonalData {
    void setRegion(String region);

    String getRegion();

    void setCity(String city);

    String getCity();

    void setStreet(String street);

    String getStreet();

    void setBuildingNumber(String buildingNumber);

    String getBuildingNumber();

    void setDescrition(String descrition);

    String getDescrition();

    String getFullPhoneNumber();

    void setPhoneNumber(int phone);

    int getPhoneNumber();

    void setEmail(String email);

    String getEmail();
}
