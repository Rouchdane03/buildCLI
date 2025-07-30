package com.rouchdane.person;

import java.io.IOException;

public interface UserDao {

    //abstract methods
    User[] getUsers() throws IOException;
}
