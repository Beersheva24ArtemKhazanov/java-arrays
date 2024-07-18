package telran.util;

import java.util.Comparator;

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
        int middle = (left + right) / 2;
        while (left <= right && ar[middle] != key) {
            if (key < ar[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left > right ? -(left + 1) : middle; 
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
        // return true if a given array has exactly one swap to get sorted array
        // the swaped array's elements may or may not be neighbors
        boolean res = false;
        int index1 = -1;
        int index2 = 0;
        index1 = getFirstIndex(array);
        if (index1 > -1) {
            index2 = getSecondIndex(array, index1);
            res = isOneSwapCheck(array, index1, index2);
        }
        return res;

    }

    private static boolean isOneSwapCheck(int[] array, int index1, int index2) {
        swap(array, index1, index2);
        boolean res = isArraySorted(array);
        swap(array, index2, index1); //array restored after swap
        return res;
    }

    private static boolean isArraySorted(int[] array) {
        int index = 1;
        while (index < array.length && array[index] >= array[index - 1]) {
            index++;
        }
        return index == array.length;
    }

    private static int getSecondIndex(int[] array, int index1) {
        int index = array.length - 1;
        int lowBorder = index1 + 1;
        while (index > lowBorder && array[index] >= array[index1]) {
            index--;
        }
        
        return index;
        
    }

    private static int getFirstIndex(int[] array) {
        int index = 0;
        int limit = array.length - 1;
        while(index < limit && array[index] <= array[index + 1]) {
            index++;
        }
        return index == limit ? -1 : index;
    }

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        int length = array.length;
        boolean flSort = false;
        do {
             length--;
             flSort = true;
             for(int i = 0; i < length; i++) {
                 if(comparator.compare(array[i], array[i + 1]) > 0) {
                     swap(array, i, i + 1);
                     flSort = false;
                 }
             }
        }while(!flSort);
     }

    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2;
        while (left <= right && comp.compare(array[middle], key) != 0) {
            if (comp.compare(array[middle], key) > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left > right ? -(left + 1) : middle; 
    }
}
