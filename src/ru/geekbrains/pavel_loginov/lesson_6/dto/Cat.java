package ru.geekbrains.pavel_loginov.lesson_6.dto;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        count++;
        runDistanceRestriction = 200;
        swimDistanceRestriction = 0;
    }
}
