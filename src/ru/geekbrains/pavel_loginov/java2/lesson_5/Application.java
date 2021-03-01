package ru.geekbrains.pavel_loginov.java2.lesson_5;

public class Application {
    private static final int size = 1000000;
    private static final int h = size / 2;
    private float[] arr = new float[size];

    public static void main(String[] args) {
        Application app = new Application();
        app.calculateArraySerial();
        app.calculateArrayParallel();
    }

    public void calculateArraySerial() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("serial time spent: " + (endTime - a));
    }

    public void calculateArrayParallel() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        float[] a1 = new float[size];
        float[] a2 = new float[size];

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = h; i < size; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long endTime = System.currentTimeMillis();
        System.out.println("parallel time spent: " + (endTime - startTime));
    }
}
