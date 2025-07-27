package com.rouchdane.car;

public class CarService {

    static {
        System.out.println("ya dabord moi CarService");
    }
    private CarDao carDao ;

    public CarService(){
        this.carDao = new CarDao();
    }
    public int addCar(Car car){

        //expmles de business logics qu'on peut faire ici
        // check if car is no null
        // check if brand is valid
        // check if model is not blank
        // check if year's creation is before 2015

        if (car.getYear()>2015){
            throw new IllegalArgumentException("we do not accept car over 2015");
        }
        //store in database
        carDao.saveCar(car);
        return 1; // return int parce que c'est int que renvoie la bdd si on insère une ligne / save une data
    }

    public Car[] getCars(){
        return carDao.selectAllCars();
    }
}
