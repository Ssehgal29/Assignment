package com.example.assignment;

public class TripData {
    String userName;
    String userAddress;
    String userRides;
    String userFreeRides;
    String userCredits;
    String boardingStation;
    String boardingTime;
    String departureStation;
    String departureTime;
    String tripCost;
    String travelTime;

    public TripData(String userName, String userAddress, String userRides,
                    String userFreeRides, String userCredits, String boardingStation,
                    String boardingTime, String departureStation, String departureTime,
                    String tripCost, String travelTime) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.userRides = userRides;
        this.userFreeRides = userFreeRides;
        this.userCredits = userCredits;
        this.boardingStation = boardingStation;
        this.boardingTime = boardingTime;
        this.departureStation = departureStation;
        this.departureTime = departureTime;
        this.tripCost = tripCost;
        this.travelTime = travelTime;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserRides() {
        return userRides;
    }

    public String getUserFreeRides() {
        return userFreeRides;
    }

    public String getUserCredits() {
        return userCredits;
    }

    public String getBoardingStation() {
        return boardingStation;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getTripCost() {
        return tripCost;
    }

    public String getTravelTime() {
        return travelTime;
    }
}
