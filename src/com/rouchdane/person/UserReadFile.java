package com.rouchdane.person;

import java.io.IOException;
import java.util.UUID;

public interface UserReadFile {

    //abstract methods
    User[] readAndExtractData(String filePath) throws IOException;

    //default methods
    default User parseLineAndGiveUser(String line){
        String[] vals = line.split(",");
        User user = new User(UUID.fromString(vals[0]),vals[1]);
        return user;
    }
}
