package com.rouchdane;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.rouchdane.utils.Booking.*;


public class Main {

    public static void main(String[] args) {

        lauchBookingCarApp();

    }

    private static void lauchBookingCarApp() {
        int input =0;
        do {
            try {
                displayBookingOptions();
                Scanner scanner = new Scanner(System.in);
                input= scanner.nextInt();
                displaySelectedOption(input);
                doThisAction(input);
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("invalid input : "+e.getMessage());
                System.out.println("Try again");
            }
        } while (input !=7);
    }


}
