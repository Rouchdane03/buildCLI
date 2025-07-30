package com.rouchdane.utils;

import com.rouchdane.car.CarBookingDao;
import com.rouchdane.car.CarBookingService;
import com.rouchdane.car.CarBuildDao;
import com.rouchdane.car.CarBuildService;
import com.rouchdane.person.UserArrayDataService;
import com.rouchdane.person.UserDao;
import com.rouchdane.person.UserService;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Booking {

    private static final UserDao userDao = new UserArrayDataService();
    private static final UserService userService = new UserService(userDao);
    private static final CarBookingDao carBookingDao = new CarBookingDao();
    private static final CarBookingService carBookingService  = new CarBookingService(carBookingDao,userService);
    private static final CarBuildDao carBuildDao = new CarBuildDao();
    private static final CarBuildService carBuildService = new CarBuildService(carBuildDao,carBookingService,userService);

    public static void displayBookingOptions(){
        String[] options = {
                "1\uFE0F⃣ - Book Car",
                "2\uFE0F⃣ - View All User Booked Cars",
                "3\uFE0F⃣ - View All Bookings",
                "4\uFE0F⃣ - View Available Cars",
                "5\uFE0F⃣ - View Available Electric Cars",
                "6\uFE0F⃣ - View all users",
                "7\uFE0F⃣ - Exit"
        };
        for (int i = 0; i <7 ; i++) {
            System.out.println(options[i]);
        }
    }

    public static void doThisAction(int input) {
            switch (input){

                case 1 :{
                    System.out.println("Alright! You want to book a car");
                    carBuildService.viewAvailableCars();

                    Scanner scanner = new Scanner(System.in);
                    System.out.print("➡️ select a regNumber : ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // consume the \n

                    try {
                        userService.viewAllUsers();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.print("➡️ select user id : ");
                    String s = scanner.nextLine();

                    try {
                        carBuildService.bookACar(value,UUID.fromString(s));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                    break;

                case 2 :{
                    System.out.println("Alright! You want to view All User Booked Cars");
                    try {
                        userService.viewAllUsers();
                        carBookingService.viewAllUsersBookings();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());;
                    }
                }
                break;

                case 3 :{
                    System.out.println("Alright! You want to View All Bookings");
                    carBookingService.viewAllBookings();
                }
                break;

                case 4 :{
                    System.out.println("Alright! You want to View Available Cars");
                    carBuildService.viewAvailableCars();
                }
                break;

                case 5 :{
                    System.out.println("Alright! You want to View Available Electric Cars");
                    carBuildService.viewAvailableElectricCars();
                }
                break;

                case 6 :{
                    System.out.println("Alright! You want to View View all users");
                    try {
                        userService.viewAllUsers();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;

                case 7:
                    System.out.println("See you next time, bye 👋🏾");
                break;

                default:
                    System.out.println("Unavailable option selected");
            }
    }
}
