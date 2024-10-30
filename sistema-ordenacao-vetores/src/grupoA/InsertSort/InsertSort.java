package grupoA.InsertSort;

public class InsertSort {

    public static int[] vetorAtual = {};
    public static int qtdeTrocas = 0;
    public static int qtdeIteracoes = 0;

    public static void sort(int tamanhoVetor) {
        // realiza a ordenacao
        for (int i = 1; i < tamanhoVetor; i++) {
            // Segundo elemento da lista
            int proximo = vetorAtual[i];
            // Primeiro elemento ou atual
            int j = i - 1;

            // Verifica se o índice do valor a ser comparado não é inferior a 0
            // Ou se o valor a ser comparado é maior que o valor atual
            while (j >= 0) {
                qtdeIteracoes++; // Contabiliza a iteração

                if (vetorAtual[j] > proximo) {
                    vetorAtual[j + 1] = vetorAtual[j]; // Move o elemento para a direita
                    qtdeTrocas++; // Conta cada movimentação como uma troca
                } else {
                    break; // Se não for maior, não precisa continuar comparando
                }

                j--;
            }

            vetorAtual[j + 1] = proximo; // Insere o elemento na posição correta
        }
    }
}