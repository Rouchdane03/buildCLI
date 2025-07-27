package com.rouchdane;

import com.rouchdane.person.PersonFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String content = """
    id,first_name,last_name,email,gender
    1,Fanchette,Williamson,fwilliamson0@github.com,F
    2,Aleksandr,Matts,amatts1@webs.com,M
    3,Maurie,Cordero,mcordero2@google.co.jp,M
    4,Donnajean,Crowson,dcrowson3@google.com.hk,F
    5,Ricardo,Gofton,rgofton4@nytimes.com,M
    6,Gabie,Tregenna,gtregenna5@guardian.co.uk,F
    7,Marjorie,Blumsom,mblumsom6@joomla.org,F
    8,Lester,Huyghe,lhuyghe7@jugem.jp,M
    9,Merrily,Stangoe,mstangoe8@tiny.cc,F
    10,Reider,Karel,rkarel9@github.io,M
    11,Dory,Jolliff,djolliffa@wufoo.com,F
    12,Homerus,Averay,haverayb@skyrock.com,M
    13,Alyda,Muglestone,amuglestonec@is.gd,F
    14,Pinchas,Louca,ploucad@google.es,M
    15,Cherin,Eltringham,celtringhame@parallels.com,F
    16,Mufi,Rothert,mrothertf@dropbox.com,F
    17,Jordana,Everex,jeverexg@ucla.edu,F
    18,Belle,Rother,brotherh@auda.org.au,F
    19,Clevie,Sifflett,csiffletti@furl.net,M
    20,Gretchen,Abell,gabellj@1688.com,F
""";

        File file = new File("src/data.csv");
        createTheFile(file);

        writeContentInFile(content,file,false);

        readTheContentInFile(file);


    }

    private static void createTheFile(File fileName) {

        try {
            if (!fileName.exists()) {
                fileName.createNewFile();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void writeContentInFile(String content, File file, boolean autoAppend){

        String[] tab = content.split("\n");

        try {
            FileWriter fileWriter = new FileWriter(file,autoAppend);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (String s: tab){
                printWriter.println(s);
            }
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void readTheContentInFile(File file){
        try {
            Scanner scanner = new Scanner(file);
            List<PersonFile> pes = new ArrayList<>();
            scanner.nextLine();//skip the header

            while (scanner.hasNext()){
                String s = scanner.nextLine();
                String[] rep = s.trim().split(",");
                PersonFile p = new PersonFile(Integer.parseInt(rep[0]),rep[1],rep[2],rep[3],rep[4]);
                pes.add(p);
            }
            System.out.println(pes);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
