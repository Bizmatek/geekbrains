package ru.geekbrains.pavel_loginov.java2.lesson_3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        //1
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven", "two", "two", "two", "three", "six");
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String word : list) {
            Integer value = map.getOrDefault(word, 0);
            map.put(word, value + 1);
        }

        System.out.println("unique words:");
        map.forEach((k, v) -> {
            System.out.println(k);
        });
        System.out.println("\ncount of words:");
        System.out.println(map);

        //2
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ivanov", "+12312313");
        phonebook.add("Ivanov", "+77777777");
        phonebook.add("Petrov", "+44444444");

        System.out.println("\nphone numbers by lastName:");
        System.out.printf("Ivanov's numbers: %s\n", phonebook.get("Ivanov"));
        System.out.printf("Petrov's numbers: %s\n", phonebook.get("Petrov"));
        System.out.printf("Sidorov's numbers: %s\n", phonebook.get("Sidorov"));
    }
}
