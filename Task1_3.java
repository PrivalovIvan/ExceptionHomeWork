package HomeWork;

import java.util.Arrays;

public class Task1_3 {
    public static void main(String[] args) {
        int[] arr1 = { 12, 4, 16, 60, 8, 21, 10 };
        int[] arr2 = { 3, 2, 8, 6, 4, 3, 1 };
        method1(arr1, arr2);
    }

    public static int[] method1(int[] arr1, int[] arr2) {
        int lengthArrRes = arr1.length;
        int[] result = new int[lengthArrRes];

        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }
        for (int i = 0; i < arr1.length; i++) {
            int difference = arr1[i] / arr2[i];
            result[i] = difference;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
