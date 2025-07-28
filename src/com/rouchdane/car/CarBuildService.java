package com.rouchdane.car;

import com.rouchdane.person.User;
import com.rouchdane.person.UserService;

import java.time.LocalDateTime;
import java.util.UUID;

public class CarBuildService {

    private CarBuildDao carBuildDao;

    public CarBuildService() {
        this.carBuildDao = new CarBuildDao();

    }

    public void viewAvailableElectricCars(){

        for(CarBuild c : carBuildDao.getCars()){
             if (c.isElectric() && !c.isCarBooked()){
                 System.out.println(c);
             }
        }
    }

    public void viewAvailableCars(){

        for(CarBuild c : carBuildDao.getCars()){
            if (!c.isCarBooked()){
                System.out.println(c);
            }
        }
    }

    public CarBooking bookACar(int regNumber, UUID userId) {

        System.out.println("🚀Booking the car with this regNumber :  "+regNumber+" to the user with this id : "+userId+" ......");
        //1
        flipCarStatus(regNumber);
        CarBuild carBuild = findCarByRegNumber(regNumber);

        //2
        UserService userService = new UserService();
        userService.flipUserBookingStatus(userId);
        User us = userService.findUserById(userId);
        System.out.println("🎉Successfully booked car with reg number "+regNumber+" for user "+us);

        //3
        UUID bookingRef = UUID.randomUUID();
        CarBooking carBooked  = new CarBooking(bookingRef,us,carBuild, LocalDateTime.now());
        System.out.println("Booking ref : "+bookingRef);

        return carBooked;

    }

    public void flipCarStatus(int regNumber){
        for(CarBuild c : carBuildDao.getCars()){
            if (c.getRegNumber() == regNumber){
                c.setCarBooked(true);
            }
        }
    }

    public CarBuild findCarByRegNumber(int regNumber){
        CarBuild carBuild = new CarBuild();
        for(CarBuild c : carBuildDao.getCars()){
            if (c.getRegNumber() == regNumber){
                carBuild = c;
                break;
            }
        }
        return carBuild;
    }
}
