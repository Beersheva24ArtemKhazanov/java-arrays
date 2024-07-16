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

    public static boolean pushMaxAtEnd(int[] ar, int length) {
        boolean res = true;
        for (int i = 0; i < length; i++) {
            if (ar[i] > ar[i + 1]) {
                res = false;
                swap(ar, i, i + 1);
            }
        }
        return res;
    }

    public static void sort(int[] ar) {
        int length = ar.length;
        boolean flSorted = false;
        while (!flSorted) {
            flSorted = true;
            length--;
            flSorted = pushMaxAtEnd(ar, length);

        }
    }

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    public static int binarySearch(int[] ar, int key) {
        // TODO
        int left = 0;
        int right = ar.length - 1;
        int index = 0;
        int mid = 0;
        while (left <= right) {
        mid = left + (right - left) / 2;
            if (ar[mid] == key) {
                index = mid;
                break;
            } else if (ar[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index == mid && index != 0 ? index : -left - 1;   
    } 

    public static int[] insertSorted(int[] arSorted, int number) {
        int[] res = java.util.Arrays.copyOf(arSorted, arSorted.length + 1);
        int index = Math.abs(binarySearch(res, number)) - 1;
        if (index == res.length) {
            index--;
        }
        if (index == -1 || index == 1) {
            index++;
        }
        System.arraycopy(arSorted, 0, res, 0, index);
        res[index] = number;
        System.arraycopy(arSorted, index, res, index + 1, arSorted.length - index);
        return res;
    }

    public static boolean isOneSwap(int[] array) {
        // TODO
        boolean res = false;
        if (array.length <= 1) {
            res = true;
        }
        int countSwaps = 0;
        boolean isSwapOne = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                for (int j = i + 2; j < array.length; j++) {
                    if (array[i] > array[j] && array[j] <= array[i + 1]) {
                        countSwaps++;
                        isSwapOne = false;
                        break;
                    }
                }
                if (isSwapOne) {
                    countSwaps++;
                }
            }
        }
        res = countSwaps == 1 ? !res : res;
        return res;

    }
}
