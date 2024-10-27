package grupoA.InsertSort;

public class InsertSort {
    // metodo para ordenar usando insert sort
    public static void sort(int[] vetor) {
        int trocas = 0;
        int iteracoes = 0;

        // percorre o vetor a partir do segundo elemento
        for (int i = 1; i < vetor.length; i++) {
            int key = vetor[i];
            int j = i - 1;

            // move elementos maiores que a chave para frente
            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j--;
                trocas++;
                iteracoes++;
            }
            vetor[j + 1] = key;
            iteracoes++;
        }

        // exibe o numero de trocas e iteracoes
        System.out.println("insert sort - trocas: " + trocas + ", iteracoes: " + iteracoes);
    }
}
