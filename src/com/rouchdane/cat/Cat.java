package com.rouchdane.cat;

import java.util.Objects;

public class Cat {

    public static int count = 0;
    private String name;

    private int age;

    private String color;

    public Cat(String name, int age, String color){
        this(name,age);
        this.color = color;
        count++;
    }

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        count++;
    }

    public Cat(String name){
        this.name = name;
        this.age = 0;
        count++;
    }

    public Cat(){
        count++;
    }

    public void meow(){
        System.out.println(name + ": meow meow");
    }

    // name
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    // age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // color
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat = {\n" +
            "  \"name\": \"" + name + "\",\n" +
                    "  \"age\": " + age + ",\n" +
                    "  \"color\": \"" + color + "\"\n" +
                    "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, color);
    }
}
