package ru.geekbrains.pavel_loginov.java2.lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> phonesMap = new HashMap<>();

    public void add(String lastName, String number) {
        phonesMap.computeIfPresent(lastName, (key, value) -> {
            value.add(number);
            return value;
        });

        phonesMap.computeIfAbsent(lastName, k -> {
            List<String> numbers = new ArrayList<>();
            numbers.add(number);
            return numbers;
        });
    }

    public List<String> get(String lastName) {
        return phonesMap.getOrDefault(lastName, List.of("Not found"));
    }
}
