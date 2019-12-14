package com.example.assignment;

public class ProfileData {
    String userFirstName;
    String userLastName;
    String userCity;
    String userCountry;
    String userImage;
    String userRides;
    String userFreeRides;
    String currencyType;
    String userCredits;

    public ProfileData(String userFirstName, String userLastName, String userCity, String userCountry,String userImage,String userRides,String userFreeRides,String currencyType,String userCredits) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userCity = userCity;
        this.userCountry = userCountry;
        this.userImage = userImage;
        this.userRides = userRides;
        this.userFreeRides = userFreeRides;
        this.currencyType = currencyType;
        this.userCredits = userCredits;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserCity() {
        return userCity;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getUserRides() {
        return userRides;
    }

    public String getUserFreeRides() {
        return userFreeRides;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public String getUserCredits() {
        return userCredits;
    }
}
