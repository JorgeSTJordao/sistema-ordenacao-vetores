package grupoA.InsertSort;

public class InsertSort {

    public static int[] vetorAtual;
    public static long qtdeTrocas = 0;
    public static long qtdeIteracoes = 0;

    public static void sort(int tamanhoVetor) {
        // realiza a ordenacao
        for (int i = 1; i < tamanhoVetor; i++) {
            // Segundo elemento da lista
            int valorAtual = vetorAtual[i];

            // Primeiro elemento ou atual
            int j = i - 1;

            // Verifica se o índice do valor a ser comparado não é inferior a 0
            // Ou se o valor a ser comparado é maior que o valor atual
            while (j >= 0) {
                qtdeIteracoes++; // Contabiliza a iteração

                //A cada troca o valor da posição "j" deixa de ser o atual
                if (vetorAtual[j] > valorAtual) {
                    vetorAtual[j + 1] = vetorAtual[j]; // Move o elemento para a direita
                    qtdeTrocas++; // Conta cada movimentação como uma troca
                } else {
                    break; // Se não for maior, não precisa continuar comparando
                }

                j--;
            }

            vetorAtual[j + 1] = valorAtual; // Insere uma posição depois do elemento menor que ele
                                            // Caso seja a primeira posição (menor elemento), j será -1
        }
    }
}