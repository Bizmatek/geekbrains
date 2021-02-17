package ru.geekbrains.pavel_loginov.java2.lesson2;

import ru.geekbrains.pavel_loginov.java2.lesson2.exceptions.MyDataArrayException;
import ru.geekbrains.pavel_loginov.java2.lesson2.exceptions.MySizeArrayException;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        String[][] array = {
                {"1", "2", "3"},
                {"4", "invalid", "6"},
                {"7", "8", "9"}
        };
        try {
            System.out.println(app.summArrayElements(array));
        } catch(MySizeArrayException | MyDataArrayException e){
            e.printStackTrace();
        }
    }

    public int summArrayElements(String[][] array) throws MyDataArrayException, MySizeArrayException{
        if (array.length > 4 || array[0].length > 4) {
            throw new MySizeArrayException("Array length more then 4");
        }

        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    summ += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyDataArrayException(String.format("Unable to cast String to integer in cell [%d:%d]", i, j));
                }
            }
        }
        return summ;
    }
}
