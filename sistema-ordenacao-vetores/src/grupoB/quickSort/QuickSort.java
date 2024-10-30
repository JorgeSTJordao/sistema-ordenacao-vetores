package grupoB.quickSort;

public class QuickSort {

    public static int[] vetorAtual = {};
    public static int qtdeTrocas = 0;
    public static int qtdeIteracoes = 0;
    public static void sort(int tamanhoVetor){
        tamanhoVetor -= 1;
        quickSort(0, tamanhoVetor);
    }

    public static void quickSort(int inicio, int fim){
        if (inicio < fim){
            int pivot = particao(inicio, fim);

            quickSort(inicio, pivot-1);
            quickSort(pivot+1, fim);
        }
    }

    public static int particao(int inicio, int fim){
        int pivot = vetorAtual[fim];
        int i = inicio;

        for (int j = inicio; j < fim; j++){
            if (vetorAtual[j] <= pivot){
                int aux = vetorAtual[j];
                vetorAtual[j] = vetorAtual[i];
                vetorAtual[i] = aux;
                i += 1;
            }

            int aux =  vetorAtual[i];
            vetorAtual[i] = vetorAtual[fim];
            vetorAtual[fim] = aux;
        }

        return i;
    }

}
