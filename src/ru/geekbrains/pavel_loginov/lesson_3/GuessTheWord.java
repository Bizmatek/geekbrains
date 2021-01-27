package ru.geekbrains.pavel_loginov.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    private static final String INPUT_REQUEST_MESSAGE = "Try to guess the word:";
    private static final String FAIL_MESSAGE = "It's a wrong answer";
    private static final String SUCCESS_MESSAGE = "Great job!!!";
    private static final String MASK_CHAR = "#";

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String secretWord = words[new Random() {
        }.nextInt(words.length)];
        Scanner in = new Scanner(System.in);
        String userWord = null;

        while (!secretWord.equals(userWord)) {
            System.out.println(INPUT_REQUEST_MESSAGE);
            userWord = in.next();
            if (!secretWord.equals(userWord)) {
                System.out.println(FAIL_MESSAGE);
                printChars(secretWord, userWord, compareWordsLengthAndGetMin(secretWord, userWord));
                System.out.println();
            } else{
                System.out.println(SUCCESS_MESSAGE);
            }
        }
    }

    public static int compareWordsLengthAndGetMin(String word1, String word2){
        if (word1.length() > word2.length()) {
            return word2.length();
        } else {
            return word1.length();
        }
    }

    public static void printChars(String userWord, String secretWord, int wordLength){
        int charCounter = 0;
        for (int i = 0; i < wordLength; i++) {
            if (secretWord.charAt(i) == userWord.charAt(i)) {
                System.out.print(secretWord.charAt(i));
                charCounter = i;
            } else {
                charCounter = i;
                System.out.print(MASK_CHAR);
            }
        }
        for (int i = charCounter + 1; i < 15; i++) {
            System.out.print(MASK_CHAR);
        }
    }
}
