package DataSorterProject;

import java.util.*;

public class MainProgram {

    static Scanner sc = new Scanner(System.in);
    static int[] data;

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1 -> enterNumbers();
                case 2 -> generateRandom();
                case 3 -> bubble();
                case 4 -> merge();
                case 5 -> quick();
                case 6 -> compareAll();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);
    }

    static void enterNumbers() {
        System.out.print("Enter number of elements: ");
        int n = getIntInput();
        data = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            data[i] = getIntInput();
        }
        System.out.println("Data entered successfully!");
    }

    static void generateRandom() {
        System.out.print("Enter number of random numbers to generate: ");
        int n = getIntInput();
        data = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) data[i] = r.nextInt(1000);
        System.out.println("Generated Random Data:");
        System.out.println(Arrays.toString(data));
    }

    static void bubble() {
        if (!check()) return;
        int[] arr = Arrays.copyOf(data, data.length);
        long start = System.nanoTime();
        int steps = BubbleSortModule.bubbleSort(arr);
        long end = System.nanoTime();
        System.out.println("Bubble Sort: " + Arrays.toString(arr));
        System.out.println("Time: " + (end - start) / 1e6 + " ms | Steps: " + steps);
    }

    static void merge() {
        if (!check()) return;
        int[] arr = Arrays.copyOf(data, data.length);
        long start = System.nanoTime();
        int steps = MergeSortModule.mergeSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        System.out.println("Merge Sort: " + Arrays.toString(arr));
        System.out.println("Time: " + (end - start) / 1e6 + " ms | Steps: " + steps);
    }

    static void quick() {
        if (!check()) return;
        int[] arr = Arrays.copyOf(data, data.length);
        long start = System.nanoTime();
        int steps = QuickSortModule.quickSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        System.out.println("Quick Sort: " + Arrays.toString(arr));
        System.out.println("Time: " + (end - start) / 1e6 + " ms | Steps: " + steps);
    }

    static void compareAll() {
        if (!check()) return;
        System.out.printf("%-15s %-15s %-15s%n", "Algorithm", "Time (ms)", "Steps");

        int[] arr;
        long start, end;
        double time;
        int steps;

        arr = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        steps = BubbleSortModule.bubbleSort(arr);
        end = System.nanoTime();
        time = (end - start) / 1e6;
        System.out.printf("%-15s %-15.3f %-15d%n", "Bubble Sort", time, steps);

        arr = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        steps = MergeSortModule.mergeSort(arr, 0, arr.length - 1);
        end = System.nanoTime();
        time = (end - start) / 1e6;
        System.out.printf("%-15s %-15.3f %-15d%n", "Merge Sort", time, steps);

        arr = Arrays.copyOf(data, data.length);
        start = System.nanoTime();
        steps = QuickSortModule.quickSort(arr, 0, arr.length - 1);
        end = System.nanoTime();
        time = (end - start) / 1e6;
        System.out.printf("%-15s %-15.3f %-15d%n", "Quick Sort", time, steps);
    }

    static boolean check() {
        if (data == null || data.length == 0) {
            System.out.println("No data! Please enter or generate numbers first.");
            return false;
        }
        return true;
    }

    static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Invalid input, enter again: ");
            }
        }
    }
}