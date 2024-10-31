package grupoB.mergeSort;

public class MergeSort {

    public static int[] vetorAtual;
    public static long qtdeTrocas = 0; // Contador de trocas
    public static long qtdeIteracoes = 0; // Contador de iterações

    public static void sort(int tamanhoAtual) {
        split(0, tamanhoAtual); // Chama o método split para o comprimento da lista
    }

    public static void split(int indiceInicial, int comprimento) {
        // Comprimento do vetor
        if (comprimento - indiceInicial > 1) {
            int metade = (comprimento + indiceInicial) / 2;

            // Separação na forma recursiva
            //Cada separação cria uma sublista do vetorAtual
            split(indiceInicial, metade);
            split(metade, comprimento);

            merge(indiceInicial, metade, comprimento);
        }
    }

    public static void merge(int inicio, int meio, int fim) {
        // Criação dos vetores com tamanhos baseados nos índices
        int tamanhoEsquerda = meio - inicio;
        int tamanhoDireita = fim - meio;

        // Vetores temporários
        int[] vetorEsquerda = new int[tamanhoEsquerda];
        int[] vetorDireita = new int[tamanhoDireita];

        // Copia os valores para os vetores temporários
        for (int i = 0; i < tamanhoEsquerda; i++) {
            vetorEsquerda[i] = vetorAtual[inicio + i];
        }

        for (int i = 0; i < tamanhoDireita; i++) {
            vetorDireita[i] = vetorAtual[meio + i];
        }

        // Máximo valor da esquerda de cada vetor, sempre inicia em 0
        int topoEsquerda = 0;
        int topoDireita = 0;

        //Índice de início a partir do vetor
        int i = inicio;
        int aux;

        // Merge dos dois vetores
        while (topoEsquerda < tamanhoEsquerda && topoDireita < tamanhoDireita) {
            qtdeIteracoes++; // Incrementa a contagem de iterações

            if (vetorEsquerda[topoEsquerda] <= vetorDireita[topoDireita]) {
                //A posição do vetor é alterada para a menor
                aux = vetorAtual[i];
                vetorAtual[i] = vetorEsquerda[topoEsquerda];
                topoEsquerda++;
            } else {
                //Considerando que o topo da direita foi alterado, se torna o próximo valor da lista
                aux = vetorAtual[i];
                vetorAtual[i] = vetorDireita[topoDireita];
                topoDireita++;
            }

            if (vetorAtual[i] != aux)
                qtdeTrocas++; // Conta como uma troca

            i++;
        }

        // Elementos que sobraram por não terem sido percorridos na sublista da esquerda, caso haja
        while (topoEsquerda < tamanhoEsquerda) {
            vetorAtual[i] = vetorEsquerda[topoEsquerda];
            i++;
            topoEsquerda++;
        }

        // Elementos que sobraram por não terem sido percorridos na sublista da direita, caso haja
        while (topoDireita < tamanhoDireita) {
            vetorAtual[i] = vetorDireita[topoDireita];
            i++;
            topoDireita++;
        }
    }
}