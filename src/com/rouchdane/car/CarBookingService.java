package com.rouchdane.car;

import com.rouchdane.person.UserService;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class CarBookingService {

    private CarBookingDao carBookingDao;
    private UserService userService ;

    public CarBookingService(CarBookingDao carBookingDao, UserService userService){
        this.carBookingDao = carBookingDao;
        this.userService = userService;
    }

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

    public void viewAllUsersBookings() throws IOException {

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
