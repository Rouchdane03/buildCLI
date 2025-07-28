package com.rouchdane.utils;

import com.rouchdane.car.CarBuildService;
import com.rouchdane.person.UserService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Booking {

    public static String data = "";
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

    public static void displaySelectedOption(int val){
        String text = switch (val){
            case 1 -> "Alright! You want to book a car";
            case 2 -> "Alright! You want to view All User Booked Cars";
            case 3 -> "Alright! You want to View All Bookings";
            case 4 -> "Alright! You want to View Available Cars";
            case 5 -> "Alright! You want to View Available Electric Cars";
            case 6 -> "Alright! You want to View View all users";
            case 7 -> "See you next time, bye 👋🏾";
            default -> "Unavailable option selected";

        };
        System.out.println(text);
    }


    public static void doThisAction(int input) {

        if (input>0 && input<=7){

            switch (input){
                case 1 :{
                    CarBuildService carBuildService = new CarBuildService();
                    carBuildService.viewAvailableCars();


                    Scanner scanner = new Scanner(System.in);

                    System.out.print("➡️ select a regNumber : ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // consume the \n

                    UserService userService = new UserService();
                    userService.viewAllUsers();

                    System.out.print("➡️ select user id : ");
                    String s = scanner.nextLine();

                    String result = carBuildService.bookACar(value,UUID.fromString(s)).toString();
                    data +=result + " ";
                }
                    break;

                case 2 :{
                    UserService userService = new UserService();
                    userService.viewAllUsers();
                    userService.viewAllUserBookedCars();
                }
                break;

                case 3 :{
                    System.out.println("booking = "+Arrays.toString(getAllBookings()));
                }
                break;

                case 4 :{
                    CarBuildService carBuildService = new CarBuildService();
                    carBuildService.viewAvailableCars();

                }
                break;

                case 5 :{
                    CarBuildService carBuildService = new CarBuildService();
                    carBuildService.viewAvailableElectricCars();
                }
                break;

                case 6 :{

                    UserService userService = new UserService();
                    userService.viewAllUsers();

                }
                break;
                case 7:
                break;
                default:
                    System.out.println("Unavailable option selected");
            }
        }
    }

    public static String[] getAllBookings(){
        String[] result = data.split(" ");
        return result;
    }
    
//    public static void displayAllUsersBookings(UUID uuid){
//        String[] looping = getAllBookings();
//        for(ArrayValuesType nameVariable : arraysName){
//
//        }
//    }
    
    
}
