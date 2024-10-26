import dados.Armazenamento;

// inicio do programa
public class Main {
    public static void main(String[] args) {
        Armazenamento armazenamento = new Armazenamento();

        // gerar vetores aleatorios
        armazenamento.gerarVetoresAleatorios();

        // obter vetores gerados
        int[][] vetor = armazenamento.getVetores();

        // clonar o primeiro vetor para ordenacao
        int[] vetorParaOrdenar = vetor[0].clone();

        // testar insert sort
        int[] vetorInsert = vetorParaOrdenar.clone();
        insertSort(vetorInsert);

        // testar counting sort
        int maxValue = findMax(vetorParaOrdenar);
        int[] vetorCounting = vetorParaOrdenar.clone();
        countingSort(vetorCounting, maxValue);

        // exibir os primeiros 10 elementos do vetor ordenado
        for (int i = 0; i < 10; i++) {
            System.out.print(vetorInsert[i] + ", ");
        }
    }

    // funcao para ordenar usando insert sort
    public static void insertSort(int[] vetor) {
        int trocas = 0;
        int iteracoes = 0;

        // percorre o vetor a partir do segundo elemento
        for (int i = 1; i < vetor.length; i++) {
            int key = vetor[i];
            int j = i - 1;

            // move os elementos maiores que a chave uma posicao para frente
            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j--;
                trocas++;
                iteracoes++;
            }
            vetor[j + 1] = key;
            iteracoes++;
        }

        // mostra o numero de trocas e iteracoes realizadas
        System.out.println("insert sort - trocas: " + trocas + ", iteracoes: " + iteracoes);
    }

    // funcao para ordenar usando counting sort
    public static void countingSort(int[] vetor, int maxValue) {
        int iteracoes = 0;

        // encontrar o valor minimo para ajustar o intervalo
        int minValue = findMin(vetor);
        int range = maxValue - minValue + 1;

        // criar o array de contagem com base no intervalo
        int[] count = new int[range];
        int[] output = new int[vetor.length];

        // contar as ocorrencias de cada elemento ajustando pelo valor minimo
        for (int i = 0; i < vetor.length; i++) {
            count[vetor[i] - minValue]++;
            iteracoes++;
        }

        // acumulacao dos valores de contagem
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
            iteracoes++;
        }

        // construir o vetor ordenado
        for (int i = vetor.length - 1; i >= 0; i--) {
            output[count[vetor[i] - minValue] - 1] = vetor[i];
            count[vetor[i] - minValue]--;
            iteracoes++;
        }

        // copiar o vetor ordenado de volta para o original
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = output[i];
            iteracoes++;
        }

        // mostra o numero de iteracoes realizadas
        System.out.println("counting sort - iteracoes: " + iteracoes);
    }

    // funcao para encontrar o valor minimo em um vetor
    public static int findMin(int[] vetor) {
        int min = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < min) {
                min = vetor[i];
            }
        }
        return min;
    }

    // funcao para encontrar o valor maximo em um vetor
    public static int findMax(int[] vetor) {
        int max = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {
                max = vetor[i];
            }
        }
        return max;
    }
}
