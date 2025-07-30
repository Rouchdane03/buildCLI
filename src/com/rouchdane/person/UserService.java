package com.rouchdane.person;

import java.io.IOException;
import java.util.UUID;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void viewAllUsers() throws IOException {
        for(User user : userDao.getUsers()) {
            System.out.println(user);
        }
    }

    public User findUserById(UUID userId) throws IOException{
        User u = new User();
        for(User user : userDao.getUsers()){
            if (user.getId().equals(userId)){
               u = user;
               break;
            }
        }
        return u;
    }


    public void flipUserBookingStatus(UUID uuid) throws IOException{
        for(User c : userDao.getUsers()){
            if (c.getId().equals(uuid)){
                c.setBooked(true);
            }
        }
    }
}
