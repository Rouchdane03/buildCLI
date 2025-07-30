package com.rouchdane.person;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserArrayDataService implements UserDao, UserReadFile{

    private static final String filePath;
    private static User[] users = {};

    static {
        filePath = "src/com/rouchdane/users.csv";
    }

    @Override
    public User[] getUsers() throws IOException{
        if(users.length>0){
            return users;
        }else {
            User[] data = readAndExtractData(filePath);
            return data;
        }
    }

    @Override
    public User[] readAndExtractData(String filePath) throws IOException {
        //define a file
        File file = new File(filePath);
        if (!file.exists()){
            //create if not exists
            file.createNewFile();
        }
        Scanner scanner = new Scanner(file);
        String firstData = scanner.nextLine();
        int iterate = 0;
        users = new User[]{parseLineAndGiveUser(firstData)};
        iterate++;

        while (scanner.hasNext()){
            String aData = scanner.nextLine();
            extendUsersArray();
            users[iterate++] = parseLineAndGiveUser(aData);
        }
        return users;
    }

    private static void extendUsersArray() {
        User[] usersExtended = new User[users.length+1];
        for (int i = 0; i < users.length; i++) {
            usersExtended[i] = users[i];
        }
        users = usersExtended;
    }
}
