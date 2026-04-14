public class Busca {

    // Busca Sequencial (O(n))
    public static int sequencial(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // encontrou
            }
        }
        return -1; // não encontrou
    }

    // Busca Binária (O(log n)) - precisa de array ordenado!
    public static int binaria(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // não encontrou
    }
}
