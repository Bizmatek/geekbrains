package ru.geekbrains.pavel_loginov.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 3;
    private static final String FAIL_MESSAGE_TEMPLATE = "Your number %s then secret. Try again...\n";
    private static final String SUCCESS_MESSAGE = "Correct! You won!\n";
    private static final String GAME_OVER_MESSAGE = "You lose, do you want to play again? y/n ";
    private static final String INPUT_REQUEST_MESSAGE = "Input number between 0 and 9 (inclusively)";
    private static final String Y_ANSWER = "y";
    private static final String N_ANSWER = "n";

    public static void main(String[] args) {
        boolean isStop = false;
        int attemptCount = 0;

        while (!isStop) {
            int currentAttempt = 0;
            int secretNumber = new Random() {
            }.nextInt(9);
            System.out.println(INPUT_REQUEST_MESSAGE);
            Scanner in = new Scanner(System.in);
            while (attemptCount != MAX_ATTEMPTS) {
                currentAttempt = in.nextInt();
                if(compareValues(currentAttempt, secretNumber)){
                    isStop = true;
                    break;
                } else {
                    attemptCount++;
                }
            }
            if (!isStop) {
                boolean isExit = false;
                while (!isExit) {
                    System.out.print(GAME_OVER_MESSAGE);
                    String answer = in.next();
                    if (answer.equals(N_ANSWER)) {
                        isStop = true;
                        break;
                    } else if (answer.equals(Y_ANSWER)) {
                        isExit = true;
                        attemptCount = 0;
                    }
                }
            }
        }
    }

    public static boolean compareValues(int currentValue, int secretValue){
        if (currentValue < secretValue) {
            System.out.printf(FAIL_MESSAGE_TEMPLATE, "less");
        } else if (currentValue > secretValue) {
            System.out.printf(FAIL_MESSAGE_TEMPLATE, "more");
        } else {
            System.out.println(SUCCESS_MESSAGE);
            return true;
        }
        return false;
    }
}
