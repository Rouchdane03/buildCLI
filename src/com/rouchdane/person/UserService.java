package com.rouchdane.person;

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
