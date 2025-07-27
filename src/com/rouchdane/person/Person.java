package com.rouchdane.person;

import com.rouchdane.address.Address;
import com.rouchdane.car.Car;

import java.util.Arrays;
import java.util.Objects;

public class Person {

    private String name;
    private int age;
    private Gender gender;

    // Une personne peut avoir plusieurs voitures et adresses
    private Car[] cars;
    private Address[] addresses;

    // Constructeur par défaut
    public Person() {}

    // Constructeur pratique
    public Person(String name, int age, Gender gender, Car[] cars, Address[] addresses) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.cars = cars;
        this.addresses = addresses;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", cars=" + Arrays.toString(cars) +
                ", addresses=" + Arrays.toString(addresses) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && gender == person.gender && Objects.deepEquals(cars, person.cars) && Objects.deepEquals(addresses, person.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, Arrays.hashCode(cars), Arrays.hashCode(addresses));
    }
}
