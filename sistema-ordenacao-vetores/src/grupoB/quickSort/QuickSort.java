package grupoB.quickSort;

public class QuickSort {

    public static int[] vetorAtual = {};
    public static long qtdeTrocas = 0;
    public static long qtdeIteracoes = 0;

    public static void sort(int tamanhoVetor) {
        qtdeTrocas = 0; // Resetando contadores
        qtdeIteracoes = 0;
        tamanhoVetor -= 1;
        quickSort(0, tamanhoVetor);
    }

    public static void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int pivot = particao(inicio, fim);
            quickSort(inicio, pivot - 1);
            quickSort(pivot + 1, fim);
        }
    }

    public static int particao(int inicio, int fim) {
        int pivot = vetorAtual[fim];
        int i = inicio;

        for (int j = inicio; j < fim; j++) {
            qtdeIteracoes++; // Incrementando a quantidade de iterações

            if (vetorAtual[j] <= pivot) {
                // Realiza a troca
                int aux = vetorAtual[j];
                vetorAtual[j] = vetorAtual[i];
                vetorAtual[i] = aux;

                if (j > inicio && j <= fim - 1)
                    qtdeTrocas++; // Incrementando a quantidade de trocas

                i += 1;
            }
        }

        // Troca final para colocar o pivot na posição correta
        int aux = vetorAtual[i];
        vetorAtual[i] = vetorAtual[fim];
        vetorAtual[fim] = aux;

        if (i != inicio)
            qtdeTrocas++; // Incrementando a quantidade de trocas

        return i;
    }
}