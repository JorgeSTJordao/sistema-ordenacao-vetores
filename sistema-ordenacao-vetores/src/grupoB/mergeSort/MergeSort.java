package grupoB.mergeSort;

public class MergeSort
{

    public static void separar(int[] vetorAtual, int tamanhoAtual, int aux){
        //Se o tamanho atual for menor que dois, indica que só sobrou um elemento na lista
        if (tamanhoAtual < 2){
            return;
        }

        //Separa ao meio o vetor atual
        int meio = tamanhoAtual / 2;

        int[] esquerda = new int[meio];
        int[] direita = new int[tamanhoAtual - meio];

        //Armazena os valores separados do vetor raiz no vetor criado na esquerda
        //Caso seja menor, indica que chegou no pico, isto é, um único elemento
        for (int i = 0; i < meio; i++){
            esquerda[i] = vetorAtual[i];
        }

        //Os restantes ficam na direita
        for (int i = meio; i < tamanhoAtual; i++){
            direita[i - meio] = vetorAtual[i];
        }

        //Separar até o último vetor da esquerda
        separar(esquerda, meio, aux);
        //Separar até o último vetor da direita
        separar(direita, tamanhoAtual - meio, aux);

        //Agora que todos foram separados até o mínimo vetor possível podemos fazer um mergeSort (ordenar)
        mergeSort(vetorAtual, esquerda, direita, meio, tamanhoAtual - meio);

        if (tamanhoAtual == aux) {
            for (int i = meio; i < tamanhoAtual; i++) {
                System.out.print(vetorAtual[i] + " ");
            }
            System.out.println();
        }
    }

    public static void mergeSort(int[] vetorAtual, int[] vetorEsquerda, int[] vetorDireita, int esquerda, int direita) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < esquerda && j < direita){
            //O vetor da esquerda é menor que o da direita (1 < 2)
            if (vetorEsquerda[i] <= vetorDireita[j])
                //v[0] = 1
                vetorAtual[k++] = vetorEsquerda[i++];
            //Ou vetor da esquerda é menor que o da direita (3 < 2)
            else
                //v[0] = 2
                vetorAtual[k++] = vetorDireita[j++];
        }

        while (i < esquerda) {
            vetorAtual[k++] = vetorEsquerda[i++];
        }

        while (j < direita){
            vetorAtual[k++] = vetorDireita[j++];
        }
    }
}
