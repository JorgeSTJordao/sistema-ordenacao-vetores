package grupoC.CountingSort;

public class CountingSort {
    // metodo para ordenar usando counting sort
    public static void sort(int[] vetor) {
        int minValue = findMin(vetor);
        int maxValue = findMax(vetor);
        int range = maxValue - minValue + 1;
        int[] count = new int[range];
        int[] output = new int[vetor.length];
        int iteracoes = 0;

        // conta as ocorrencias de cada elemento no vetor
        for (int i = 0; i < vetor.length; i++) {
            count[vetor[i] - minValue]++;
            iteracoes++;
        }

        // soma acumulativa no array de contagem
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
            iteracoes++;
        }

        // coloca os elementos na ordem correta no array de saida
        for (int i = vetor.length - 1; i >= 0; i--) {
            output[count[vetor[i] - minValue] - 1] = vetor[i];
            count[vetor[i] - minValue]--;
            iteracoes++;
        }

        // copia o vetor de saida para o vetor original
        System.arraycopy(output, 0, vetor, 0, vetor.length);

        // exibe o numero de iteracoes
        System.out.println("counting sort - iteracoes: " + iteracoes);
    }

    // encontra o menor valor no vetor
    private static int findMin(int[] vetor) {
        int min = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < min) {
                min = vetor[i];
            }
        }
        return min;
    }

    // encontra o maior valor no vetor
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