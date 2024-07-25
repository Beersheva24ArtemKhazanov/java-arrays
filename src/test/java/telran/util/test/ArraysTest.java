package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import telran.util.CharacterRule;

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
        String[] strings = { "lmn", "cfta", "w", "aa" };
        String[] expectdASCII = { "aa", "cfta", "lmn", "w" };
        String[] expectedLength = { "w", "aa", "lmn", "cfta" };
        sort(strings, (a, b) -> a.compareTo(b));
        assertArrayEquals(expectdASCII, strings);
        sort(strings, (a, b) -> Integer.compare(a.length(), b.length()));
        assertArrayEquals(expectedLength, strings);
    }

    @Test
    void testBinarySearchAnyType() {
        String[] stringSortedASCII = { "ba", "cfta", "lmn", "w" };
        String[] stringSortedLength = { "w", "aa", "lmn", "cfta" };
        Integer[] numbers = { 1000, 2000 };
        Integer[] numbers1 = { 1000, 2000, 3000, 4545, 5896 };
        Comparator<String> compStrings = (a, b) -> a.compareTo(b);
        Comparator<Integer> compInteger = Integer::compare;
        assertEquals(1, binarySearch(stringSortedASCII, "cfta", compStrings));
        assertEquals(-5, binarySearch(stringSortedASCII, "wt", compStrings));
        assertEquals(-1, binarySearch(stringSortedASCII, "aab", compStrings));
        assertEquals(-5, binarySearch(stringSortedLength, "www", compStrings));
        assertEquals(2, binarySearch(stringSortedLength, "lmn", compStrings));
        assertEquals(0, binarySearch(numbers, 1000, compInteger));
        assertEquals(3, binarySearch(numbers1, 4545, compInteger));
        assertEquals(-6, binarySearch(numbers1, 6584, compInteger));
        assertEquals(-3, binarySearch(numbers1, 2500, compInteger));
    }

    @Test
    void testBinarySearchNoComparator() {
        String[] strings = { "ba", "cfta", "lmn", "w" };
        Person prs1 = new Person(10, "Vasya");
        Person prs2 = new Person(20, "Petya");
        Person prs3 = new Person(30, "Sara");
        Person[] persons = { prs1, prs2, prs3 };
        assertEquals(1, binarySearch(strings, "cfta"));
        assertEquals(0, binarySearch(persons, prs1));
        assertEquals(0, binarySearch(persons, prs1));
        assertEquals(-1, binarySearch(persons, new Person(5, "Kolya")));
    }

    @Test
    void evenOddSorting() {
        Integer[] array = { 7, -8, 10, -100, 13, -10, 99 };
        Integer[] expected = { -100, -10, -8, 10, 99, 13, 7 };
        sort(array, (a, b) -> {
            int res = 1;
            if (a % 2 == 0 && b % 2 == 0) {
                res = a - b;
            } else if (a % 2 != 0 && b % 2 != 0) {
                res = b - a;
            } else if (b % 2 == 0) {
                res = 1;
            } else {
                res = -1;
            }
            return res;
        });
        assertArrayEquals(expected, array);
    }

    @Test
    void testFind() {
        Integer[] array = { 7, -8, 10, -100, 13, -10, 99 };
        Integer[] expected = { 7, 13, 99, };
        assertArrayEquals(expected, find(array, n -> n % 2 != 0));
    }

    @Test
    void testRemoveIf() {
        Integer[] array = { 7, -8, 10, -100, 13, -10, 99 };
        Integer[] expected = { -8, 10, -100, -10 };
        assertArrayEquals(expected, removeIf(array, n -> n % 2 != 0));
    }
    @Test
    void matchesRulesTest() {
        CharacterRule isUpperCase = new CharacterRule(true, Character::isUpperCase, "no_capital");
        CharacterRule isLowerCase = new CharacterRule(true, Character::isLowerCase, "no_lowerCase");
        CharacterRule isDigit = new CharacterRule(true, Character::isDigit, "no_digit");
        CharacterRule isDot = new CharacterRule(true, c -> c == '.', "no_dot");
        CharacterRule isSpace = new CharacterRule(false, c -> c == ' ', "space_disallowed");
        CharacterRule[] mustBeRules = {isUpperCase, isLowerCase, isDigit, isDot};
        CharacterRule[] mustBeNotRules = {isSpace};
        char[] chars1 = {'a', 'n', '*', 'G', '.', '.', '1'};
        char[] chars2 = {'a', 'n', '*', 'G', '.', '.', '1', ' '};
        char[] chars3 = {'a', 'n', '*',  '.', '.', '1'};
        char[] chars4 = {'a', 'n', '*', 'G', '.', '.'};
        char[] chars5 = {'a', 'n', '*', 'G', '4', 'd'};
        char[] chars6 = {'a', 'n', '*', 'd', ' '};
        assertEquals("matches", matchesRules(chars1, mustBeRules, mustBeNotRules));
        assertEquals(isSpace.errorMessage, matchesRules(chars2, mustBeRules, mustBeNotRules));
        assertEquals(isUpperCase.errorMessage, matchesRules(chars3, mustBeRules, mustBeNotRules));
        assertEquals(isDigit.errorMessage, matchesRules(chars4, mustBeRules, mustBeNotRules));
        assertEquals(isDot.errorMessage, matchesRules(chars5, mustBeRules, mustBeNotRules));
        assertEquals("no_capital no_digit no_dot space_disallowed", matchesRules(chars6, mustBeRules, mustBeNotRules));
        //TODO
        //Must be rules: at least one capital letter, at least one lower case letter, at least one digit, at least one dot(.)
        //Must not be rules: space is disallowed
        //examples: mathes - {'a', 'n', '*', 'G', '.', '.', '1'}
        //mismatches - {'a', 'n', '*', 'G', '.', '.', '1', ' '} -> "space disallowed",
        // {'a', 'n', '*',  '.', '.', '1'} -> "no capital",
        // {'a', 'n', '*', 'G', '.', '.'} -> "no digit"
    }
}
