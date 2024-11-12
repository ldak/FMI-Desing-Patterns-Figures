package utils;

import java.util.Scanner;

public class ScannerSingleton {
    private static Scanner instance = new Scanner(System.in);

    private ScannerSingleton() { }

    public static Scanner getInstance() {
        return instance;
    }

    public static void close() {
        instance.close();
    }

    public static void setInstance(Scanner scanner) {
        instance = scanner;
    }
}
