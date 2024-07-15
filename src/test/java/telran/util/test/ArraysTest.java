package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static telran.util.Arrays.*;

import java.util.Random;

public class ArraysTest {
    private static final int N_ELEMENTS = 1_000;
    int[] numbers = { 10, 7, 12, -4, 13, 3, 14 };

    @Test
    void searchTest() {
        assertEquals(0, search(numbers, 10));
        assertEquals(3, search(numbers, -4));
        assertEquals(6, search(numbers, 14));
        assertEquals(-1, search(numbers, 8));
    }

    @Test
    void addTest() {
        int newNumber = 100;
        int[] expectedArray = { 10, 7, 12, -4, 13, 3, 14, newNumber };
        assertArrayEquals(expectedArray, add(numbers, newNumber));
    }

    @Test
    void insertTest() {
        int newNumber = 36;
        int index = 5;
        int[] expected = { 10, 7, 12, -4, 13, newNumber, 3, 14 };
        assertArrayEquals(expected, insert(numbers, index, newNumber));
    }

    @Test
    void removeTest() {
        int index = 3;
        int[] expected = { 10, 7, 12, 13, 3, 14 };
        assertArrayEquals(expected, remove(numbers, index));
    }

    @Test
    void sortTest() {
        int[] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length);
        sort(testNumbers);
        int [] expected = {-4, 3, 7, 10, 12, 13, 14};
        assertArrayEquals(expected, testNumbers);
    }

    @Test
    void sortTestRandomArray() {
        int[] array = getRandomArray(N_ELEMENTS);
        int limit = array.length - 1;
        sort(array);
        for(int i = 0; i < limit; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    void testBinarySearch() {
        int[] array = {-16, -8, 3, 5, 6, 12, 15, 23, 96, 115};
        int[] ar = {1, 2};
        assertEquals(6, binarySearch(array, 15));
        assertEquals(-10, binarySearch(array, 322));
        assertEquals(-7, binarySearch(array, 17));
        assertEquals(-1, binarySearch(array, -26));
        assertEquals(-2, binarySearch(ar, 5));
    }

    @Test
    void testInsertSorted() {
        int[] array = {-18, -16, -2, 3, 5, 9, 17, 23, 56, 109};
        int[] ar = {1,2};
        int[] exp = {1, 1, 2};
        int newNumber = 10;
        int[] expectedAr = {-18, -16, -2, 3, 5, 9, newNumber, 17, 23, 56, 109};
        assertArrayEquals(expectedAr, insertSorted(array, newNumber));
        assertArrayEquals(exp, insertSorted(ar, 1));
    }

    @Test
    void testIsOneSwap() {
        int[] array_1 = {-18, -16, -2, 3, 5, 17, 9, 23, 56, 109};
        int[] array_2 = {12};
        int[] array_3 = {-18, -16, -2, 3, 5, 17, 9, 56, 23, 109};
        int[] array_4 = {1, 2, 3, 4, 20, 4, 10, 4};
        assertEquals(true, isOneSwap(array_1));
        assertEquals(true, isOneSwap(array_2));
        assertEquals(false, isOneSwap(array_3));
        assertEquals(true, isOneSwap(array_4));
    }

    private int[] getRandomArray(int nElements) {
        int[] res = new int[nElements];
        Random random = new Random();
        for(int i = 0; i< nElements; i++) {
            res[i] = random.nextInt();
        }
        return res;
    }
}
