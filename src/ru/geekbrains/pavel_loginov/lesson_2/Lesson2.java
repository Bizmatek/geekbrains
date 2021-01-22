package ru.geekbrains.pavel_loginov.lesson_2;

public class Lesson2 {
    public static void main(String[] args) {
        //1
        int[] array = makeArray();
        printArray(array, "Created array: ");
        printArray(invertArray(array), "Array after inversion: ");

        //2
        array = new int[8];
        fillArray(array, 0, 3, 6, 9, 12, 15, 18, 21);
        printArray(array, "Filled array: ");

        //3
        array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(multipleIfLessThenSix(array), "Array after multiplication elements which less then six");

        //4
        int[][] array2D = fill2DArray(5);
        print2DArray(array2D);

        //5
        printArray(array, "Searching maximum in array:");
        System.out.printf("Maximum value is %d\n", findMax(array));

        //6
        System.out.printf("Does array contain balance: %b", checkBalance(new int[]{6, 9, 2, 1, 12}));

        //7
        shiftElements(new int[]{1, 2, 3, 4, 5}, -3);
    }

    public static int[] makeArray() {
        return new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    }

    public static int[] invertArray(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            if (sourceArray[i] == 0) {
                sourceArray[i] = 1;
            } else {
                sourceArray[i] = 0;
            }
        }
        return sourceArray;
    }

    public static void printArray(int[] array, String messageTemplate) {
        if (!messageTemplate.equals("")) {
            System.out.println(messageTemplate);
        }
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    public static void print2DArray(int[][] array) {
        System.out.println("2D Array:");
        for (int[] i : array) {
            printArray(i, "");
        }
        System.out.println();
    }

    public static int[] fillArray(int[] array, int... values) {
        if (array.length != values.length) {
            throw new RuntimeException("the number of arguments does not match the length of the array");
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = values[i];
        }
        return array;
    }

    public static int[] multipleIfLessThenSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    public static int[][] fill2DArray(int length) {
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && (i + j) != length - 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static boolean checkBalance(int[] array) {
        int leftSide = 0;
        int rightSide = 0;
        for (int i = 0; i < array.length - 1; i++) {
            leftSide += array[i];
        }
        rightSide += array[array.length - 1];

        for (int j = array.length - 2; j > 0; j--) {
            if (leftSide == rightSide) {
                return true;
            }
            leftSide -= array[j];
            rightSide += array[j];
        }
        return false;
    }

    public static void shiftElements(int[] array, int n) {
        printArray(array, "array before shifting:");

        if (n > 0) {
            shiftToTheRight(array, n);
        } else {
            shiftToTheLeft(array, n);
        }
        printArray(array, "array after shifting:");
    }

    public static void shiftToTheRight(int[] array, int n) {
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = tmp;
        }
    }

    public static void shiftToTheLeft(int[] array, int n) {
        int tmp;
        for (int i = 0; i < Math.abs(n); i++) {
            tmp = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = tmp;
        }
    }
}
