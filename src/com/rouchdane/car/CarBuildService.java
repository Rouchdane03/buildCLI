package com.rouchdane.car;

import com.rouchdane.person.User;
import com.rouchdane.person.UserService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class CarBuildService {

    private CarBuildDao carBuildDao;
    private CarBookingService carBookingService;
    private UserService userService;

    public CarBuildService(CarBuildDao carBuildDao, CarBookingService carBookingService, UserService service) {
        this.carBuildDao = carBuildDao;
        this.carBookingService = carBookingService;
        this.userService = service;
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

    public void bookACar(int regNumber, UUID userId) throws IOException {

        System.out.println("🚀Booking the car with this regNumber :  "+regNumber+" to the user with this id : "+userId+" ......");
        //1
        flipCarStatus(regNumber);
        CarBuild carBuild = findCarByRegNumber(regNumber);

        //2
        userService.flipUserBookingStatus(userId);
        User us = userService.findUserById(userId);
        System.out.println("🎉Successfully booked car with reg number "+regNumber+" for user "+us);

        //3
        UUID bookingRef = UUID.randomUUID();
        CarBooking carBooked  = new CarBooking(bookingRef,us,carBuild, LocalDateTime.now());
        carBookingService.addBooking(carBooked);

        System.out.println("Booking ref : "+bookingRef);

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
