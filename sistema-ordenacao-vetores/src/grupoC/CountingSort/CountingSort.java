package grupoC.CountingSort;

public class CountingSort {

    public static int[] vetorAtual = {};
    public static long qtdeTrocas = 0;
    public static long qtdeIteracoes = 0;
    public static void sort(int tamanhovetorAtualAtual) {
        //Encontrar intervalos
        int minValue = findMin(vetorAtual, tamanhovetorAtualAtual);
        int maxValue = findMax(vetorAtual, tamanhovetorAtualAtual);

        //Encontramos o range
        int range = maxValue - minValue + 1;

        //Vetor para auxiliar na ordenação
        int[] count = new int[range];
        //Output: ordenado
        int[] output = new int[tamanhovetorAtualAtual];

        //Início da ordenação
        // contagem de elementos
        for (int i = 0; i < tamanhovetorAtualAtual; i++) {
            //Acumulo de valores repetidos no vetor desordenado
            count[vetorAtual[i] - minValue]++;
            qtdeIteracoes++;
        }

        // acumulacao dos elementos
        for (int i = 1; i < range; i++) {
            //Soma as quantidades
            //Pega o valor anterior e soma ao atual
            //Cada posição indica um acumulo das somas anteriores
            count[i] += count[i - 1];
            qtdeIteracoes++;
        }

        // ordenacao do vetorAtualAtual (desde o último elemento até o primeiro)
        for (int i = tamanhovetorAtualAtual - 1; i >= 0; i--) {
            //Pega a posição atual igual ao calculo anterior e faz atribuição
            output[count[vetorAtual[i] - minValue] - 1] = vetorAtual[i];

            //A subtração da acumulação indica se os valores atingiram a posição correta
            count[vetorAtual[i] - minValue]--;
            qtdeTrocas++;
        }

        // copia o vetorAtualAtual ordenado para o original
        for (int i = 0; i < tamanhovetorAtualAtual; i++) {
            vetorAtual[i] = output[i];
        }
    }

    //Encontra o menor valor para determinar o mínimo de range
    private static int findMin(int[] vetorAtualAtual, int tamanhovetorAtualAtual) {
        int min = vetorAtualAtual[0];
        for (int i = 1; i < tamanhovetorAtualAtual; i++) {
            if (vetorAtualAtual[i] < min) {
                min = vetorAtualAtual[i];
            }
        }
        return min;
    }

    //Encontra o maior valor para determinar o máximo de range
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