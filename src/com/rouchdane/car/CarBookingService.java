package com.rouchdane.car;

import com.rouchdane.person.UserService;

import java.util.Scanner;
import java.util.UUID;

public class CarBookingService {

    private final CarBookingDao carBookingDao = new CarBookingDao();
    private final UserService userService = new UserService();

    public void addBooking(CarBooking carBooking){
         carBookingDao.insertBooking(carBooking);
    }

    public void viewAllBookings(){
        if (carBookingDao.getCarNumbersBooked() == 0){
            System.out.println("❌ Nobody booked a car");
        }
        for(CarBooking c : carBookingDao.getAllBookings()){
            if (c!=null){
                System.out.println("booking = "+c);
            }
        }
    }

    public void viewAllUsersBookings(){

        int verify = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("give me your id : ");
        String value = scanner.nextLine();
        UUID uuid = UUID.fromString(value);


        for(CarBooking c : carBookingDao.getAllBookings()){
            if (c!=null){
                if (c.getUser().getId().equals(uuid)){
                    System.out.println("booked "+verify+" car : "+c);
                    verify++;
                }
            }
        }

        if (verify == 1){
            System.out.println("❌ user "+userService.findUserById(uuid)+" has no cars booked");
        }
    }

}
