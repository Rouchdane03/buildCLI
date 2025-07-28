package com.rouchdane.person;

import com.rouchdane.car.CarBuild;

import java.util.Scanner;
import java.util.UUID;

public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public void viewAllUsers(){
        for(User user : userDao.getUsers()){
            System.out.println(user);
        }
    }

    public void viewAllUserBookedCars() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("give me your id : ");
        String value = scanner.nextLine();
        UUID uuid = UUID.fromString(value);


       for(User user : userDao.getUsers()){
         if (user.getId().equals(uuid)){
             if (!user.isBooked()){
                 System.out.println("❌ user "+user+" has no cars booked");
             }
             else {
                 System.out.println("am coming😀");
             }
         }
       }
    }

    public User findUserById(UUID userId){
        User u = new User();
        for(User user : userDao.getUsers()){
            if (user.getId().equals(userId)){
               u = user;
               break;
            }
        }
        return u;
    }


    public void flipUserBookingStatus(UUID uuid) {
        for(User c : userDao.getUsers()){
            if (c.getId().equals(uuid)){
                c.setBooked(true);
            }
        }
    }
}
