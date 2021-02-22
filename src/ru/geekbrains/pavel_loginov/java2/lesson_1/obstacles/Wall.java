package ru.geekbrains.pavel_loginov.java2.lesson_1.obstacles;

import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Cat;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Human;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Movable;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Robot;

import static ru.geekbrains.pavel_loginov.java2.lesson_1.constants.MessageConstants.FAIL_MESSAGE_TEMPLATE;

public class Wall implements Obstacle {
    private int height;

    @Override
    public boolean overcome(Movable m) {
        if (m instanceof Cat) {
            if (((Cat) m).getMaxJump() > height) {
                m.jump(height);
                return true;
            } else {
                System.out.printf(FAIL_MESSAGE_TEMPLATE, height, ((Cat) m).getName());
            }
        } else if (m instanceof Human) {
            if (((Human) m).getMaxJump() > height) {
                m.jump(height);
                return true;
            } else {
                System.out.printf(FAIL_MESSAGE_TEMPLATE, height, ((Human) m).getName());
            }

        } else if (m instanceof Robot) {
            if (((Robot) m).getMaxJump() > height) {
                m.jump(height);
                return true;
            } else {
                System.out.printf(FAIL_MESSAGE_TEMPLATE, height, ((Robot) m).getName());
            }
        }
        return false;
    }

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
