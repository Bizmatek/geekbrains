package ru.geekbrains.pavel_loginov.lesson_6;

import ru.geekbrains.pavel_loginov.lesson_6.dto.Animal;
import ru.geekbrains.pavel_loginov.lesson_6.dto.Cat;
import ru.geekbrains.pavel_loginov.lesson_6.dto.Dog;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run(){
        Animal cat = new Cat("Barsik");
        Animal dog = new Dog("Muhtar");

        cat.run(120);
        cat.swim(100);

        dog.run(300);
        dog.swim(9);

        printCountOfAnimals(List.of(cat, dog));
    }

    public void printCountOfAnimals(List<? extends Animal> animals) {
        long dogsCount = animals.stream()
                .filter(a -> (a instanceof Dog))
                .count();
        long catsCount = animals.stream()
                .filter(a -> (a instanceof Cat))
                .count();
        System.out.printf("Cats: %d\n" +
                "Dogs: %d\n" +
                "Animals: %d\n", catsCount, dogsCount, Animal.getCount());
    }
}
