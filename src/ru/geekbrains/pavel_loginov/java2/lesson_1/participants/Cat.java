package ru.geekbrains.pavel_loginov.java2.lesson_1.participants;

import static ru.geekbrains.pavel_loginov.java2.lesson_1.constants.MessageConstants.JUMP_SUCCESS_MESSAGE_TEMPLATE;
import static ru.geekbrains.pavel_loginov.java2.lesson_1.constants.MessageConstants.RUN_SUCCESS_MESSAGE_TEMPLATE;

public class Cat implements Movable {
    private int maxDistance;
    private int maxJump;
    private String name;

    public Cat(String name, int maxDistance, int maxJump) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxJump = maxJump;
    }

    public String getName() {
        return name;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public void run(int distance) {
        System.out.printf(RUN_SUCCESS_MESSAGE_TEMPLATE, getClass().getSimpleName(), name, distance);
    }

    @Override
    public void jump(int height) {
        System.out.printf(JUMP_SUCCESS_MESSAGE_TEMPLATE, getClass().getSimpleName(), name, height);
    }
}
