package ru.geekbrains.pavel_loginov.lesson_7;

import ru.geekbrains.pavel_loginov.lesson_7.dto.Cat;
import ru.geekbrains.pavel_loginov.lesson_7.dto.Plate;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.exec();
    }

    public void exec() {
        List<Cat> cats = List.of(
                new Cat("Barsik", 5),
                new Cat("Murzik", 15),
                new Cat("Vaska", 2),
                new Cat("Markiz", 7),
                new Cat("Timon", 47)
        );
        Plate plate = new Plate(60);

        feedTheCats(cats, plate);

        plate.info();
        plate.addFood(20);
        plate.info();
    }

    public void feedTheCats(List<Cat> cats, Plate plate) {
        cats.stream()
                .peek(c -> c.eat(plate))
                .forEach(c -> System.out.printf("%s's saciety: %b \n", c.getName(), c.isFull()));
    }
}
