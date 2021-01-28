package ru.geekbrains.pavel_loginov.lesson_4;

import java.util.Scanner;

public class Lesson4 {
    private static final String DOT_X = "X";
    private static final String DOT_O = "O";
    private static final String DOT_EMPTY = ".";
    private static final int MAP_SIZE = 5;
    private static final int LINE_TO_WIN_LENGTH = 4;
    private static String[][] map;

    public static void main(String[] args) {
        map = new String[MAP_SIZE][MAP_SIZE];
        map = init();
        drawField();
        while (!isExit()) {
            playerTurn();
            drawField();
            aITurn();
            drawField();
        }
    }

    public static void drawField() {
        for (int i = 0; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i - 1][j] + " ");
            }
            System.out.println();

        }
    }

    public static String[][] init() {
        String[][] map = new String[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
        return map;
    }

    public static boolean turn(int x, int y, String dot) throws IndexOutOfBoundsException {
        if (map[x - 1][y - 1].equals(DOT_EMPTY)) {
            map[x - 1][y - 1] = dot;
            return true;
        }
        System.out.println("The cell is not empty. Try again");
        return false;
    }

    public static void playerTurn() {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("your turn:");
        do {
            int x = sc.nextInt();
            int y = sc.nextInt();
            try {
                if (turn(x, y, DOT_X)) {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("The cell is out of bounds. Try again");
            }
        } while (true);
    }

    public static void aITurn() {
        System.out.println();
        System.out.println("AI turn:");

        do {
            int[] cell = pickCell();
            int x = cell[0];
            int y = cell[1];
            if (turn(x, y, DOT_O)) {
                break;
            }
        } while (true);
    }

    public static int[] pickCell() {
        int colXCount = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            int rowXCount = 0;
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j].equals(DOT_X)) {
                    rowXCount++;
                }
                if (rowXCount == LINE_TO_WIN_LENGTH - 1) {
                    for (int k = 1; k <= MAP_SIZE; k++) {
                        if (map[i][k - 1].equals(DOT_EMPTY)) {
                            return new int[]{i + 1, k};
                        }
                    }
                }
                if (map[j][i].equals(DOT_X)) {
                    colXCount++;
                }
                if (colXCount == LINE_TO_WIN_LENGTH - 1) {
                    for (int k = 1; k <= MAP_SIZE; k++) {
                        if (map[k - 1][i].equals(DOT_EMPTY)) {
                            return new int[]{k, i + 1};
                        }
                    }
                }
            }
            colXCount = 0;
        }
        return new int[]{(int) (Math.random() * MAP_SIZE + 1), (int) (Math.random() * MAP_SIZE + 1)};
    }

    public static boolean isWin(String dot) {
        int yCount = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            int xCount = 0;
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j].equals(dot)) {
                    xCount++;
                } else {
                    xCount = 0;
                }
                if (xCount == MAP_SIZE - 1) {
                    return true;
                }
                if (map[j][i].equals(dot)) {
                    yCount++;
                } else {
                    yCount = 0;
                }
                if (yCount == MAP_SIZE - 1) {
                    return true;
                }
            }
            yCount = 0;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j].equals(DOT_EMPTY))
                    return false;
            }
        }
        return true;

    }

    public static boolean isExit() {
        if (isWin(DOT_X)) {
            System.out.println("You are winner!!!");
            return true;
        }
        if (isWin(DOT_O)) {
            System.out.println("AI is winner");
            return true;
        }
        if (isMapFull()) {
            System.out.println("Dead head!");
        }
        return false;
    }
}
