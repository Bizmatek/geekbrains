package ru.geekbrains.pavel_loginov.java2.lesson_1;

import ru.geekbrains.pavel_loginov.java2.lesson_1.obstacles.Obstacle;
import ru.geekbrains.pavel_loginov.java2.lesson_1.obstacles.Treadmill;
import ru.geekbrains.pavel_loginov.java2.lesson_1.obstacles.Wall;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Cat;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Human;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Movable;
import ru.geekbrains.pavel_loginov.java2.lesson_1.participants.Robot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ru.geekbrains.pavel_loginov.java2.lesson_1.constants.MessageConstants.LEFT_RACE_MESSAGE;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        List<Obstacle> obstaclesList = List.of(
                new Wall(10),
                new Wall(15),
                new Wall(5),
                new Treadmill(30),
                new Treadmill(50),
                new Treadmill(70)
        );

        List<Movable> team = new ArrayList<Movable>(List.of(
                new Cat("Barsik", 100, 100),
                new Human("Ivan", 50, 20),
                new Robot("Bender", 10, 10)
        ));

        Iterator<Movable> teamIterator = team.iterator();
        while (teamIterator.hasNext()) {
            Movable m = teamIterator.next();
            for (Obstacle obstacle : obstaclesList) {
                if (!obstacle.overcome(m)) {
                    System.out.println(LEFT_RACE_MESSAGE);
                    teamIterator.remove();
                    break;
                }
            }
        }
    }
}
