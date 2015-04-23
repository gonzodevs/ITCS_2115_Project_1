
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.annotation.Repeatable;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MergesortTest {

    private Integer[] numbers;
    private final static int SIZE = 1000;
    private final static int MAX = 1280000;

    @Before
    public void setUp() throws Exception {
        System.out.println("Size used: "+SIZE);
        numbers = new Integer[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }

    }

    @Test
    public void testBubbleSort() {
        long startTime = System.nanoTime();

        Main m = new Main();
        m.bubbleSort(numbers);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("BubbleSort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Array is not sorted");
            }
        }
        System.out.println("--------------------------------");
        assertTrue(true);

    }

    @Test
    public void testQuickSort() {
        long startTime = System.nanoTime();

        Main sorter = new Main();
        sorter.quickSort(numbers);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort: " + elapsedTime);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Array is not sorted");
            }
        }
        System.out.println("--------------------------------");
        assertTrue(true);

    }
    @Test
    public void testSelectionSort() {
        long startTime = System.nanoTime();

        Main sorter = new Main();
        sorter.selectionSort(numbers);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("Selection: " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Array is not sorted");
            }
        }
        System.out.println("--------------------------------");
        assertTrue(true);

    }
    @Test
    public void testInsertionSort() {
        long startTime = System.nanoTime();

        Main sorter = new Main();
        sorter.insertionSort(numbers);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("Insertion: " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                fail("Should not happen");
            }
        }
        System.out.println("--------------------------------");
        assertTrue(true);

    }
    @Test
    public void testMergeSort() {
        long startTime = System.nanoTime();

        Main sorter = new Main();
        Integer[] n=sorter.mergeSort(numbers);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("MergeSort: " + elapsedTime);

        for (int i = 0; i < n.length - 1; i++) {
            if (n[i] > n[i + 1]) {
                fail("Arrays is not sorted");
            }
        }
        System.out.println("--------------------------------");
        assertTrue(true);
    }

}