package DataSorterProject;

public class QuickSortModule {

    public static int quickSort(int[] arr, int low, int high) {
        int steps = 0;
        if (low < high) {
            int[] result = partition(arr, low, high);
            int pi = result[0];
            steps += result[1];
            steps += quickSort(arr, low, pi - 1);
            steps += quickSort(arr, pi + 1, high);
        }
        return steps;
    }

    private static int[] partition(int[] arr, int low, int high) {
        int steps = 0;
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            steps++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return new int[]{i + 1, steps};
    }
}

