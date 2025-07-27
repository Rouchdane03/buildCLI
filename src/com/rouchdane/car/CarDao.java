package com.rouchdane.car;

public class CarDao {

    private static Car[] cars;
    private static int nextAvailableSlot = 0;
    private static int capacity = 20;

    static {
        System.out.println("je passe avant initalisation");
        System.out.println("je cree un tableau à "+capacity+" élements");
        System.out.println("on va créer une insatnce pour CarDao");
        cars = new Car[capacity];
    }

    public void saveCar(Car car){
        if (nextAvailableSlot+1 >= capacity){
            //grow db
        }
        //store it
        cars[nextAvailableSlot++] = car; //return and increment
    }


    public Car[] selectAllCars() {
        return cars;
    }
}
