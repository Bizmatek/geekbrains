package ru.geekbrains.pavel_loginov.lesson_6.dto;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
        count++;
        runDistanceRestriction = 500;
        swimDistanceRestriction = 10;
    }
}
