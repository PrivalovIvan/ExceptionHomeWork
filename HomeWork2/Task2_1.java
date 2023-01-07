package HomeWork.HomeWork2;

import java.util.Scanner;

public class Task2_1 {
    public static void main(String[] args) {
        System.out.println(getFloat());
    }

    public static float getFloat() {
        Scanner scanner = new Scanner(System.in);
        float number = 0;
        try {
            System.out.printf("Введите дробное число: ");
            number = scanner.nextFloat();
            return number;
        } catch (Exception e) {
            getFloat();
        }
        return number;
    }

}
