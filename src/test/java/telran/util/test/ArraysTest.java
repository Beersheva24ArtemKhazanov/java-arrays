package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static telran.util.Arrays.*;

public class ArraysTest {
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
}
