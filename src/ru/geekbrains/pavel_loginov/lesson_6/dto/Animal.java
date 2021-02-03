package ru.geekbrains.pavel_loginov.lesson_6.dto;

public abstract class Animal {
    protected String name;
    protected static int count;
    protected int runDistanceRestriction;
    protected int swimDistanceRestriction;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static int getCount(){
        return count;
    }

    public void run(int distance){
        if (distance <= runDistanceRestriction) {
            System.out.printf("%s ran %d meters\n", getName(), distance);
        } else {
            System.out.printf("%s can't run more then %d\n", getName(), swimDistanceRestriction);
        }
    }

    public void swim(int distance){
        if (distance <= swimDistanceRestriction) {
            System.out.printf("%s swam %d meters\n", getName(), distance);
        } else {
            System.out.printf("%s can't swim more then %d\n", getName(), swimDistanceRestriction);
        }
    }
}
