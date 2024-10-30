import dados.Armazenamento;
import grupoB.mergeSort.MergeSort;
import grupoA.InsertSort.InsertSort;
import grupoB.quickSort.QuickSort;
import grupoC.CountingSort.CountingSort;


//Inicio do programa
public class Main {
    public static void main(String[] args) {
        int tamanhoVetor = 3; //Quantidade de itens no vetor:  1000, 10000, 100000, 500000, 1000000
        int maxValues = 100; //Randomização desde o valor zero até "maxValues" (sempre números naturais)

        Armazenamento armazenamento = new Armazenamento();

        armazenamento.gerarVetoresAleatorios(tamanhoVetor, maxValues);

        int[][] vetores =  armazenamento.getVetores();

        //Sempre será gerado 5 vetores, pois precisamos de no mínimo 5 para o cálculo da média
        for (int i = 0; i < 5; i++){

            System.out.print("Lista desordenada: ");
            for (int j = 0; j < tamanhoVetor; j++) {
                System.out.print(vetores[i][j] + " ");
            }
            //Aqui podemos selecionar a ordenação que desejamos
            System.out.println();
            ordenar(2, vetores[i], tamanhoVetor);
        }
    }

    public static void ordenar(int codigo, int[] vetor, int tamanhoVetor){
        switch (codigo) {
            case 1 -> {
                // caso do grupo A (Insert Sort)]
                InsertSort.qtdeIteracoes = 0;
                InsertSort.qtdeTrocas = 0;
                InsertSort.vetorAtual = vetor;

                long inicioContagem = System.currentTimeMillis();
                InsertSort.sort(tamanhoVetor);
                long contagemFinalMilissegundos = System.currentTimeMillis() - inicioContagem;

                imprimir(InsertSort.vetorAtual, InsertSort.qtdeTrocas, InsertSort.qtdeIteracoes);

                System.out.println("Tempo total (ms): " + contagemFinalMilissegundos);
                System.out.println();
            }
            case 2 -> {
                // caso do grupo B (Merge Sort)
                MergeSort.qtdeIteracoes = 0;
                MergeSort.qtdeTrocas = 0;
                MergeSort.vetorAtual = vetor;

                long inicioContagem = System.currentTimeMillis();
                MergeSort.sort(tamanhoVetor);
                long contagemFinalMilissegundos = System.currentTimeMillis() - inicioContagem;

                imprimir(MergeSort.vetorAtual, MergeSort.qtdeTrocas, MergeSort.qtdeIteracoes);

                System.out.println("Tempo total (ms): " + contagemFinalMilissegundos);
                System.out.println();

            }
            case 3 -> {
                // caso do grupo B (Quick Sort)
                QuickSort.qtdeIteracoes = 0;
                QuickSort.qtdeTrocas = 0;
                QuickSort.vetorAtual = vetor;

                long inicioContagem = System.currentTimeMillis();
                QuickSort.sort(tamanhoVetor);
                long contagemFinalMilissegundos = System.currentTimeMillis() - inicioContagem;

                imprimir(QuickSort.vetorAtual, QuickSort.qtdeTrocas, QuickSort.qtdeIteracoes);

                System.out.println("Tempo total (ms): " + contagemFinalMilissegundos);
                System.out.println();
            }
            case 4 -> {
                // caso do grupo C (Counting Sort)
                CountingSort.qtdeIteracoes = 0;
                CountingSort.qtdeTrocas = 0;
                CountingSort.vetorAtual = vetor;

                long inicioContagem = System.currentTimeMillis();
                CountingSort.sort(tamanhoVetor);
                long contagemFinalMilissegundos = System.currentTimeMillis() - inicioContagem;

                imprimir(CountingSort.vetorAtual, CountingSort.qtdeTrocas, CountingSort.qtdeIteracoes);

                System.out.println("Tempo total (ms): " + contagemFinalMilissegundos);
                System.out.println();
            }
            default -> {
                System.out.println("tente de novo!");
            }
        }
    }

    public static void imprimir(int[] vetor, int qtdeTrocas, int qtdeIteracoes){
        System.out.print("Lista ordenada: ");

        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println("| Qtde de trocas: " + qtdeTrocas + "| Qtde de iterações:" + qtdeIteracoes);
    }
}