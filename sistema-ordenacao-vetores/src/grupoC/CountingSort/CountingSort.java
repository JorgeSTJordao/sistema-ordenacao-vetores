package grupoC.CountingSort;

public class CountingSort {
    public static void sort(int[] vetor) {
        int minValue = findMin(vetor);
        int maxValue = findMax(vetor);
        int range = maxValue - minValue + 1;
        int[] count = new int[range];
        int[] output = new int[vetor.length];

        // contagem de elementos
        for (int i = 0; i < vetor.length; i++) {
            count[vetor[i] - minValue]++;
        }

        // acumulacao dos elementos
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // ordenacao do vetor
        for (int i = vetor.length - 1; i >= 0; i--) {
            output[count[vetor[i] - minValue] - 1] = vetor[i];
            count[vetor[i] - minValue]--;
        }

        // copia o vetor ordenado para o original
        System.arraycopy(output, 0, vetor, 0, vetor.length);

        // imprime o vetor ordenado
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static int findMin(int[] vetor) {
        int min = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < min) {
                min = vetor[i];
            }
        }
        return min;
    }

    private static int findMax(int[] vetor) {
        int max = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {
                max = vetor[i];
            }
        }
        return max;
    }
}