public class Ordenacao {

    // ======================
    // MERGE SORT (O n log n)
    // ======================
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copia de volta
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }

    // ======================
    // QUICK SORT (O n log n)
    // ======================
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // troca
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // coloca o pivô no lugar certo
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
