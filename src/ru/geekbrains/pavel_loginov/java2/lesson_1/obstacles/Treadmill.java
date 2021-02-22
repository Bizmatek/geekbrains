package ru.geekbrains.pavel_loginov.java2.lesson_1.obstacles;

import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Cat;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Human;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Movable;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Robot;

import static ru.geekbrains.pavel_loginov.java2.lesson_1.constants.MessageConstants.FAIL_MESSAGE_TEMPLATE;

public class Treadmill implements Obstacle {
    private int length;

    @Override
    public boolean overcome(Movable m) {
        if (m instanceof Cat) {
            if (((Cat) m).getMaxDistance() >= length) {
                m.run(length);
                return true;
            } else {
                System.out.printf(FAIL_MESSAGE_TEMPLATE, length, ((Cat) m).getName());
            }
        } else if (m instanceof Human) {
            if (((Human) m).getMaxDistance() >= length) {
                m.run(length);
                return true;
            } else {
                System.out.printf(FAIL_MESSAGE_TEMPLATE, length, ((Human) m).getName());
            }
        } else if (m instanceof Robot) {
            if (((Robot) m).getMaxDistance() >= length) {
                m.run(length);
                return true;
            } else {
                System.out.printf(FAIL_MESSAGE_TEMPLATE, length, ((Robot) m).getName());
            }
        }
        return false;
    }

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
