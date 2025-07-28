package com.rouchdane.car;

import java.math.BigDecimal;

public class CarBuildDao {

    private static CarBuild[] cars;

    static {
        cars = new CarBuild[]{
                new CarBuild(4211,new BigDecimal("200"),"TESLA",true),
                new CarBuild(8123,new BigDecimal("8430.78"),"AUDI",false),
                new CarBuild(3471,new BigDecimal("210.78"),"TOYOTA",true),
                new CarBuild(9182,new BigDecimal("218.34"),"MERCEDES",false)
        };
    }

    public CarBuild[] getCars(){
            return cars;
    }
}
