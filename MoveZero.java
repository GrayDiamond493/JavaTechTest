import java.util.*;

class MoveZero {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 0, 4, 3, 0, 5, 0 };
        System.out.print("Loop Implementation" + '\n');
        System.out.print("Array :" + Arrays.toString(arr) + '\n');
        System.out.print("Pushed Zeros :" + Arrays.toString(zeroMoverLoop(arr)) + '\n' + '\n');

        int[] arr2 = { 1, 2, 0, 4, 3, 0, 5, 0 };
        System.out.print("Reverse Implementation" + '\n');
        System.out.print("Array :" + Arrays.toString(arr2) + '\n');
        System.out.print("Pushed Zeros :" + Arrays.toString(zeroMoverReverse(arr)) + '\n' + '\n');

        int[] arr3 = { 1, 2, 0, 4, 3, 0, 5, 0 };
        System.out.print("Only Push Implementation (No sort)" + '\n');
        System.out.print("Array :" + Arrays.toString(arr3) + '\n');
        System.out.print("Pushed Zeros :" + Arrays.toString(zeroMover(arr3)));
    }

    // New Implementation (No-Sort)
    public static int[] zeroMover(int[] arr) {
        int aux = 0;
        int j = 0;

        for (int i = 0; i < (arr.length); i++) {
            if (arr[i] != 0) {
                aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;
                j++;
                System.out.print("Swapped step at :" + i + " " + Arrays.toString(arr) + '\n');
            }
        }

        return arr;

    }

    // Original Loop Implementation
    public static int[] zeroMoverLoop(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length / 2; i++) {
            int aux = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = aux;
        }

        return arr;
    }

    // Reverse Implementation
    // Credits for use of Integer for reverse:
    // https://www.geeksforgeeks.org/collections-reverse-method-in-java-with-examples/
    public static Object[] zeroMoverReverse(int[] arr) {
        Arrays.sort(arr);
        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        Collections.reverse(Arrays.asList(array));
        return array;
    }
}