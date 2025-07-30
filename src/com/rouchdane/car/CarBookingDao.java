package com.rouchdane.car;

public class CarBookingDao implements CarBookingInterface{

    private static CarBooking[] data ;
    private static int initValue, countBooked;


    static {
        data = new CarBooking[1];
        initValue = 0;
        countBooked = 0;
    }

    @Override
    public void insertBooking(CarBooking carBooking) {
            if (initValue == data.length) {
                extendAndReassignData();
            }
        data[initValue++] = carBooking;
        countBooked++;
    }

    private static void extendAndReassignData() {
        CarBooking[] dataBackup = new CarBooking[data.length+1];
        for (int i = 0; i < data.length; i++) {
            dataBackup[i] = data[i];
        }
        data = dataBackup;
    }

    @Override
    public CarBooking[] getAllBookings(){
        return data;
    }

    public int getCarNumbersBooked(){
        return countBooked;
    }
}
