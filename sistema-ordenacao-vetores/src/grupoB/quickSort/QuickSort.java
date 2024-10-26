package grupoB.quickSort;

public class QuickSort {

    public static void quickSort(int[] vetorAtual, int inicio, int fim){
        if (inicio < fim){
            int particaoIndice = particao(vetorAtual, inicio, fim);

            quickSort(vetorAtual, inicio, particaoIndice-1);
            quickSort(vetorAtual, particaoIndice+1, fim);
        }
    }

    public static int particao(int[] vetorAtual, int inicio, int fim){
        int pivot = vetorAtual[fim];
        int i = (inicio -1);

        for (int j = inicio; j < fim; j++){
            if (vetorAtual[j] <= pivot){
                i++;

                int swapTemp = vetorAtual[i];
                vetorAtual[i] = vetorAtual[j];
                vetorAtual[j] = swapTemp;
            }

        }

        int swapTemp = vetorAtual[i + 1];
        vetorAtual[i + 1] = vetorAtual[fim];
        vetorAtual[fim] = swapTemp;

        return i + 1;
    }
}
