package telran.util;

public class Arrays {
    public static int search(int[] ar, int key) {
        // TODO
        int index = 0;
        while (index < ar.length && key != ar[index]) {
            index++;
        }
        return index == ar.length ? -1 : index;
    }

    public static int[] add(int[] ar, int number) {
        // TODO
        int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[ar.length] = number;
        return res;
    }

    // public static int[] insert(int[] ar, int index, int number) {
    //     // TODO
    //     int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
    //     int key = 0;
    //     while (key < index) {
    //         res[key] = ar[key];
    //         key++;
    //     }
    //     res[index] = number;
    //     while (key < ar.length) {
    //         res[key + 1] = ar[key];
    //         key++;
    //     }
    //     return res;
    // }

    // public static int[] remove(int[] numbers, int index) {
    //     // TODO
    //     int[] res = java.util.Arrays.copyOf(numbers, numbers.length - 1);
    //     int key = 0;
    //     while (key <= index) {
    //         res[key] = numbers[key];
    //         key++;
    //     }
    //     while (key > index && key -1  < res.length) {
    //         res[key - 1] = numbers[key];
    //         key++;
    //     }
    //     return res;
    // }

    public static int[] insert(int[] ar, int index, int number) {
        int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        System.arraycopy(ar, 0, res, 0, index);
        res[index] = number;
        System.arraycopy(ar, index, res, index + 1, ar.length - index);
        return res;
    }

    public static int[] remove(int[] numbers, int index) {
        int[] res = java.util.Arrays.copyOf(numbers, numbers.length - 1);
        System.arraycopy(numbers, index + 1, res, index, numbers.length - index - 1);
        return res;
    }
}
