package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static telran.util.Arrays.*;

import java.util.Comparator;
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
        int[] expected = { -4, 3, 7, 10, 12, 13, 14 };
        assertArrayEquals(expected, testNumbers);
    }

    @Test
    void sortTestRandomArray() {
        int[] array = getRandomArray(N_ELEMENTS);
        int limit = array.length - 1;
        sort(array);
        for (int i = 0; i < limit; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    void testBinarySearch() {
        int[] array = { -16, -8, 3, 5, 6, 12, 15, 23, 96, 115 };
        int[] ar = { 1, 2 };
        assertEquals(6, binarySearch(array, 15));
        assertEquals(-11, binarySearch(array, 322));
        assertEquals(-8, binarySearch(array, 17));
        assertEquals(-1, binarySearch(array, -26));
        assertEquals(0, binarySearch(array, -16));
        assertEquals(9, binarySearch(array, 115));
        assertEquals(-3, binarySearch(ar, 5));
        assertEquals(-1, binarySearch(ar, 0));
    }

    @Test
    void testInsertSorted() {
        int[] exp2 = { 1, 2, 5 };
        int[] array = { -18, -16, -2, 3, 5, 9, 17, 23, 56, 109 };
        int[] ar = { 1, 2 };
        int[] exp = { 1, 1, 2 };
        int newNumber = 10;
        int[] expectedAr = { -18, -16, -2, 3, 5, 9, newNumber, 17, 23, 56, 109 };
        assertArrayEquals(expectedAr, insertSorted(array, newNumber));
        assertArrayEquals(exp, insertSorted(ar, 1));
        assertArrayEquals(exp2, insertSorted(ar, 5));
    }

    @Test
    void testIsOneSwap() {
        int[] array_1 = { -18, -16, -2, 3, 5, 17, 9, 23, 56, 109 };
        int[] array_3 = { -18, -16, -2, 3, 5, 17, 9, 56, 23, 109 };
        int[] array_4 = { 1, 2, 3, 4, 20, 4, 10, 4 };
        assertEquals(true, isOneSwap(array_1));
        assertEquals(false, isOneSwap(array_3));
        assertEquals(true, isOneSwap(array_4));
    }

    private int[] getRandomArray(int nElements) {
        int[] res = new int[nElements];
        Random random = new Random();
        for (int i = 0; i < nElements; i++) {
            res[i] = random.nextInt();
        }
        return res;
    }

    @Test
    void testSortAnyType() {
        String[] strings = {"lmn", "cfta", "w", "aa"};
        String[] expectdASCII = {"aa", "cfta", "lmn", "w"};
        String[] expectedLength = {"w", "aa", "lmn", "cfta"};
        sort(strings, new ComparatorASCII());
        assertArrayEquals(expectdASCII, strings);
        sort(strings, new ComparatorLength());
        assertArrayEquals(expectedLength, strings);
    }

    @Test
    void testBinarySearchAnyType() {
        String[] stringSortedASCII = {"ba", "cfta", "lmn", "w"};
        String[] stringSortedLength = {"w", "aa", "lmn", "cfta"};
        Integer[] numbers = {1000, 2000};
        Integer[] numbers1 = {1000, 2000, 3000, 4545, 5896};
        assertEquals(1, binarySearch(stringSortedASCII, "cfta", new ComparatorASCII()));
        assertEquals(-5, binarySearch(stringSortedASCII, "wt", new ComparatorASCII()));
        assertEquals(-1, binarySearch(stringSortedASCII, "aab", new ComparatorASCII()));
        assertEquals(2, binarySearch(stringSortedLength, "lmn", new ComparatorLength()));
        assertEquals(-4, binarySearch(stringSortedLength, "www", new ComparatorLength()));
        assertEquals(0, binarySearch(numbers, 1000, new ComparatorNumbers()));
        assertEquals(3, binarySearch(numbers1, 4545, new ComparatorNumbers()));
    }
}
