package com.example.assignment;

public class TripData {
    String boardingStation;
    String boardingTime;
    String departureStation;
    String departureTime;
    String currencyType;
    String tripCost;
    String travelTime;

    public TripData(String boardingStation,String departureStation,
                    String boardingTime, String departureTime,
                    String currencyType,String tripCost, String travelTime) {
        this.boardingStation = boardingStation;
        this.boardingTime = boardingTime;
        this.departureStation = departureStation;
        this.departureTime = departureTime;
        this.currencyType = currencyType;
        this.tripCost = tripCost;
        this.travelTime = travelTime;
    }

    public String getBoardingStation() {
        return boardingStation;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public String getTripCost() {
        return tripCost;
    }

    public String getTravelTime() {
        return travelTime;
    }
}
