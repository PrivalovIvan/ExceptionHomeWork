package HomeWork.HomeWork2;

import java.util.Scanner;

public class Task2_4 {
    public static void main(String[] args) throws Exception {
        dataEntry();
    }

    public static void dataEntry() throws Exception {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("")) {
            throw new Exception("пустые строки вводить нельзя.");
        }
    }
}
