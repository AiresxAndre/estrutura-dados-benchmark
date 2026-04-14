import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] tamanhos = {1000, 10000, 50000};
        int execucoes = 30;

        for (int n : tamanhos) {

            long somaTempo = 0;

            for (int i = 0; i < execucoes; i++) {

                int[] arr = gerarArray(n);

                long inicio = System.nanoTime();

                // Escolhe o algoritmo (pode trocar)
                Ordenacao.mergeSort(arr, 0, arr.length - 1);
                // Ordenacao.quickSort(arr, 0, arr.length - 1);

                long fim = System.nanoTime();

                somaTempo += (fim - inicio);
            }

            long media = somaTempo / execucoes;

            System.out.println("Tamanho: " + n);
            System.out.println("Tempo médio: " + media + " ns");
            System.out.println("------------------------");
        }
    }

    // Gera array aleatório
    public static int[] gerarArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100000);
        }

        return arr;
    }
}
