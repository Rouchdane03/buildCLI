package com.rouchdane.car;

import java.math.BigDecimal;

public class CarBuild {

    private int regNumber;

    private BigDecimal rentalPricePerDay;

    private String brand;

    private boolean isElectric;

    private boolean isCarBooked;


    {
        this.isCarBooked = false;
    }

    public CarBuild(){}


    public CarBuild(int regNumber, BigDecimal rentalPricePerDay, String brand, boolean isElectric) {
        this.regNumber = regNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public boolean isCarBooked() {
        return isCarBooked;
    }

    public void setCarBooked(boolean carBooked) {
        isCarBooked = carBooked;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return "CarBuild{" +
                "regNumber=" + regNumber +
                " ,rentalPricePerDay=" + rentalPricePerDay +
                " ,brand='" + brand + '\'' +
                " ,isElectric=" + isElectric +
                '}';
    }
}
