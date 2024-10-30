package grupoC.CountingSort;

public class CountingSort {

    public static int[] vetorAtual = {};
    public static int qtdeTrocas = 0;
    public static int qtdeIteracoes = 0;
    public static void sort(int tamanhovetorAtualAtual) {
        int minValue = findMin(vetorAtual, tamanhovetorAtualAtual);
        int maxValue = findMax(vetorAtual, tamanhovetorAtualAtual);
        int range = maxValue - minValue + 1;
        int[] count = new int[range];
        int[] output = new int[tamanhovetorAtualAtual];

        // contagem de elementos
        for (int i = 0; i < tamanhovetorAtualAtual; i++) {
            count[vetorAtual[i] - minValue]++;
        }

        // acumulacao dos elementos
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // ordenacao do vetorAtualAtual
        for (int i = tamanhovetorAtualAtual - 1; i >= 0; i--) {
            output[count[vetorAtual[i] - minValue] - 1] = vetorAtual[i];
            count[vetorAtual[i] - minValue]--;
        }

        // copia o vetorAtualAtual ordenado para o original
        for (int i = 0; i < tamanhovetorAtualAtual; i++) {
            vetorAtual[i] = output[i];
        }
    }

    private static int findMin(int[] vetorAtualAtual, int tamanhovetorAtualAtual) {
        int min = vetorAtualAtual[0];
        for (int i = 1; i < tamanhovetorAtualAtual; i++) {
            if (vetorAtualAtual[i] < min) {
                min = vetorAtualAtual[i];
            }
        }
        return min;
    }

    private static int findMax(int[] vetorAtualAtual, int tamanhovetorAtualAtual) {
        int max = vetorAtualAtual[0];
        for (int i = 1; i < tamanhovetorAtualAtual; i++) {
            if (vetorAtualAtual[i] > max) {
                max = vetorAtualAtual[i];
            }
        }
        return max;
    }
}