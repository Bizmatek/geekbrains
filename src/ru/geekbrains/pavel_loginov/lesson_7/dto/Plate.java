package ru.geekbrains.pavel_loginov.lesson_7.dto;

import ru.geekbrains.pavel_loginov.lesson_7.exceptions.NotEnoughOfFoodException;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) throws NotEnoughOfFoodException {
        if (food >= n) {
            food -= n;
        } else {
            throw new NotEnoughOfFoodException();
        }
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int foodValue){
        food += foodValue;
    }

}
