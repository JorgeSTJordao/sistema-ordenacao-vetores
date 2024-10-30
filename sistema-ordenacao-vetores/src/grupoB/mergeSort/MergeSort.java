package grupoB.mergeSort;

public class MergeSort {

    public static int[] vetorAtual = {};
    public static int qtdeTrocas = 0;
    public static int qtdeIteracoes = 0;

    public static void sort(int tamanhoAtual) {
        // Se o tamanho atual for menor que dois, indica que só sobrou um elemento na lista
        if (tamanhoAtual < 2) {
            return;
        }

        // Separa ao meio o vetor atual
        int meio = tamanhoAtual / 2;

        int[] esquerda = new int[meio];
        int[] direita = new int[tamanhoAtual - meio];

        // Armazena os valores separados do vetor raiz no vetor criado na esquerda
        for (int i = 0; i < meio; i++) {
            esquerda[i] = vetorAtual[i];
        }

        // Os restantes ficam na direita
        for (int i = meio; i < tamanhoAtual; i++) {
            direita[i - meio] = vetorAtual[i];
        }

        // Separar até o último vetor da esquerda
        sort(meio);
        // Separar até o último vetor da direita
        sort(tamanhoAtual - meio);

        // Agora que todos foram separados até o mínimo vetor possível podemos fazer um mergeSort (ordenar)
        mergeSort(vetorAtual, esquerda, direita, meio, tamanhoAtual - meio);
    }

    public static void mergeSort(int[] vetorAtual, int[] vetorEsquerda, int[] vetorDireita, int esquerda, int direita) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < esquerda && j < direita) {
            qtdeIteracoes++; // Contabiliza a iteração

            // O vetor da esquerda é menor ou igual ao da direita
            if (vetorEsquerda[i] <= vetorDireita[j]) {
                vetorAtual[k++] = vetorEsquerda[i++];
                qtdeTrocas++; // Conta como uma troca ao mover elemento da esquerda
            } else {
                vetorAtual[k++] = vetorDireita[j++];
                qtdeTrocas++; // Conta como uma troca ao mover elemento da direita
            }
        }

        while (i < esquerda) {
            vetorAtual[k++] = vetorEsquerda[i++];
            qtdeTrocas++; // Conta como uma troca ao mover elementos restantes da esquerda
        }

        while (j < direita) {
            vetorAtual[k++] = vetorDireita[j++];
            qtdeTrocas++; // Conta como uma troca ao mover elementos restantes da direita
        }
    }
}