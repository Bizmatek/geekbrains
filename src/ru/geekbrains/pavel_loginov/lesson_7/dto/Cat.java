package ru.geekbrains.pavel_loginov.lesson_7.dto;

import ru.geekbrains.pavel_loginov.lesson_7.exceptions.NotEnoughOfFoodException;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        this.isFull = full;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        try{
            p.decreaseFood(appetite);
            isFull = true;
        } catch (NotEnoughOfFoodException e){
            isFull = false;
        }
    }
}
