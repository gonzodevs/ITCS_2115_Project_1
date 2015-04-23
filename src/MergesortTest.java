
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MergesortTest {

    private Integer[] numbers;
    private final static int SIZE = 5;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new Integer[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
        System.out.println("Testing elements: "+Arrays.toString(numbers));

    }

    @Test
    public void testBubbleSort() {
        long startTime = System.currentTimeMillis();

        Main m = new Main();
        m.bubbleSort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("BubbleSort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {

                System.out.println("this caused the error:" + Arrays.toString(numbers));
                fail("Should not happen");
            }
        }
        System.out.println("passed, sorted array: "+Arrays.toString(numbers)+"");
        System.out.println("--------------------");
        assertTrue(true);

    }

    @Test
    public void testQuickSort() {
        long startTime = System.currentTimeMillis();

        Main sorter = new Main();
        sorter.quickSort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort: " + elapsedTime);
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {

                System.out.println("this caused the error:" + Arrays.toString(numbers));
                fail("Should not happen");
            }
        }
        System.out.println("passed, sorted array: "+Arrays.toString(numbers));
        assertTrue(true);

    }
    @Test
    public void testSelectionSort() {
        long startTime = System.currentTimeMillis();

        Main sorter = new Main();
        sorter.selectionSort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Selection: " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                System.out.println("this caused the error:" + Arrays.toString(numbers));
                fail("Should not happen");
            }
        }
        System.out.println("passed, sorted array: "+Arrays.toString(numbers));
        assertTrue(true);

    }
    @Test
    public void testInsertionSort() {
        long startTime = System.currentTimeMillis();

        Main sorter = new Main();
        sorter.insertionSort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Insertion: " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                System.out.println("this caused the error:" + Arrays.toString(numbers));
                fail("Should not happen");
            }
        }
        System.out.println("passed, sorted array: "+Arrays.toString(numbers));
        assertTrue(true);

    }
    @Test
    public void testMergeSort() {
        long startTime = System.currentTimeMillis();

        Main sorter = new Main();
        sorter.mergeSort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("MergeSort: " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                System.out.println("this caused the error:" + Arrays.toString(numbers));
                fail("Should not happen");
            }
        }
        System.out.println("passed, sorted array: "+Arrays.toString(numbers));
        assertTrue(true);

    }

}