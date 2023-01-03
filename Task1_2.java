package HomeWork;

import java.util.Arrays;

public class Task1_2 {
    public static void main(String[] args) {
        int[] arr1 = { 12, 4, 5, 67, 8, 23, 10 };
        int[] arr2 = { 45, 7, 8, 6, 12, 3, 1, 2 };
        method(arr1, arr2);
    }

    public static int[] method(int[] arr1, int[] arr2) {
        int lengthArrRes = arr1.length;
        int[] result = new int[lengthArrRes];

        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }
        for (int i = 0; i < arr1.length; i++) {
            int difference = arr1[i] - arr2[i];
            result[i] = difference;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
