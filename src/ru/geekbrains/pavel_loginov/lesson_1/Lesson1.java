package ru.geekbrains.pavel_loginov.lesson_1;

public class Lesson1 {
    public static void main(String[] args) {
        short shortVar = 5;
        byte byteVar = 7;
        int intVar = 10;
        long longVar = 30L;

        float floatVar = 3.14f;
        double doubleVar = 9.8;

        char charVar = 'a';
        boolean boolVar = true;

        System.out.printf("Calculation result: %.6f%n", calculate(3.5f, 4f, 7f, 8.8f));
        int a = 15;
        int b = 7;
        System.out.printf("Summ of %d and %d in range 10..20 (inclusively): %b%n", a, b, isSummInRange(a, b));
        printTheSubset(-3);
        System.out.printf("Is value negative: %b%n",isNegative(-4));
        printHello("Pavel");
        printLeapYear(822);
    }

    public static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean isSummInRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void printTheSubset(int value) {
        String stringTemplate = "Number is %s";
        String string;
        if (value < 0) {
            string = (String.format(stringTemplate, "negative"));
        } else {
            string = (String.format(stringTemplate, "positive"));
        }
        System.out.println(string);
    }

    public static boolean isNegative(int value) {
        return value < 0;
    }

    public static void printHello(String name) {
        System.out.printf("Hello, %s!%n", name);
    }

    public static void printLeapYear(int number) {
        boolean isLeap = false;
        if (number % 100 == 0) {
            if (number % 400 == 0) {
                isLeap = true;
            }
        } else if (number % 4 == 0) {
            isLeap = true;
        }
        System.out.printf("Year %d is a %s%n", number, isLeap ? "leap year" : "common year");
    }
}
