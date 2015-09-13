package com.example.bohdan.converterlab;

/**
 * Created by Bohdan on 13.09.2015.
 */
public class Banks {
        private String name;
        private String location;
        private String cityLocation;
        private String telephone;
        private String bankAdress;

    public Banks(String name, String location, String cityLocation, String telephone, String bankAdress) {
        this.name = name;
        this.location = location;
        this.cityLocation = cityLocation;
        this.telephone = telephone;
        this.bankAdress = bankAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return bankAdress;
    }

    public void setAdress(String adress) {
        this.bankAdress = adress;
    }
}
