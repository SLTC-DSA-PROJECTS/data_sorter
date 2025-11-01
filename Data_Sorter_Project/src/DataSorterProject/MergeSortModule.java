package DataSorterProject;

public class MergeSortModule {

    public static int mergeSort(int[] arr, int left, int right) {
        int steps = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            steps += mergeSort(arr, left, mid);
            steps += mergeSort(arr, mid + 1, right);
            steps += merge(arr, left, mid, right);
        }
        return steps;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int steps = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            steps++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
        return steps;
    }
}

