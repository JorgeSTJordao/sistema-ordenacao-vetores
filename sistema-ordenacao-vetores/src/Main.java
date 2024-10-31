import dados.Armazenamento;
import grupoB.mergeSort.MergeSort;
import grupoA.InsertSort.InsertSort;
import grupoB.quickSort.QuickSort;
import grupoC.CountingSort.CountingSort;

import java.util.Random;


//Inicio do programa
public class Main {
    public static void main(String[] args) {

        int[] tamanhosVetores = {1000, 10000, 100000, 500000, 1000000};
        String[] nomesAlgoritmos = {"Insertion Sort", "Merge Sort", "Quick Sort", "Counting Sort"};
        int[] codigos = {1, 2, 3, 4};

        int maxValues = 100; // Randomização até "maxValues"
        long numRodadas = 5; // Número de rodadas para o cálculo da média
        int seed = 42; // Valor de seed para replicar os resultados

        // Variáveis para armazenar as médias
        long totalTempo;
        long totalTrocas;
        long totalIteracoes;

        Armazenamento armazenamento = new Armazenamento();
        Random random = new Random(seed); // Usa o seed para gerar números aleatórios

        // Gera vetores e realiza o cálculo da média

        //Percorre códigos
        for (int j = 0; j < 4; j++){
            System.out.println("ALGORITMO: " + nomesAlgoritmos[j]);

            //Percorre tamanhos
            for (int w = 0; w < 5; w++){
                System.out.println();
                System.out.println("TAMANHO: " + tamanhosVetores[w]);

                totalTempo = 0L;
                totalTrocas = 0L;
                totalIteracoes = 0L;

                //Percorre rodadas
                for (int i = 0; i < numRodadas; i++) {
                    System.out.println("Rodada: " + i);
                    System.out.println("-----------------");

                    armazenamento.gerarVetoresAleatorios(tamanhosVetores[w], maxValues, random);
                    int[][] vetores = armazenamento.getVetores();

                    int[] vetor = vetores[0]; // Pega o primeiro vetor gerado

                    //System.out.print("Lista desordenada: ");
                    //for (int num : vetor) {
                        //System.out.print(num + " ");
                    //}
                    //System.out.println();

                    // Aqui podemos selecionar a ordenação que desejamos
                    long inicioContagem = System.currentTimeMillis();

                    long[] dadosColetados = ordenar(codigos[j], vetor, tamanhosVetores[w]);

                    long contagemFinalMilissegundos = System.currentTimeMillis() - inicioContagem;

                    totalTempo += contagemFinalMilissegundos;
                    totalTrocas += dadosColetados[1]; // Acumulando trocas do CountingSort
                    totalIteracoes += dadosColetados[0]; // Acumulando it erações do CountingSort

                    System.out.println("Tempo da rodada (ms): " + contagemFinalMilissegundos);
                }

                System.out.println("-----------------");
                System.out.println("RESULTADOS");
                System.out.println("-----------------");

                // Exibe as médias
                System.out.println("Média de tempo (ms): " + (totalTempo / numRodadas));
                System.out.println("Média de trocas: " + (totalTrocas / numRodadas ));
                System.out.println("Média de iterações: " + (totalIteracoes / numRodadas));
            }
            System.out.println();
        }

    }

    public static long[] ordenar(int codigo, int[] vetor, int tamanhoVetor) {

        long[] dadosColetados = new long[2];

        switch (codigo) {
            case 1 -> {
                // caso do grupo A (Insert Sort)
                InsertSort.qtdeIteracoes = 0;
                InsertSort.qtdeTrocas = 0;
                InsertSort.vetorAtual = vetor;

                InsertSort.sort(tamanhoVetor); // Realiza a ordenação

                //imprimir(InsertSort.vetorAtual, InsertSort.qtdeTrocas, InsertSort.qtdeIteracoes);

                dadosColetados[0] = InsertSort.qtdeIteracoes;
                dadosColetados[1] = InsertSort.qtdeTrocas;
            }
            case 2 -> {
                // caso do grupo B (Merge Sort)
                //Por possui a mesma lógica de combinação o qtde de trocas é sempre a mesma
                MergeSort.qtdeIteracoes = 0;
                MergeSort.qtdeTrocas = 0;
                MergeSort.vetorAtual = vetor;

                MergeSort.sort(tamanhoVetor);

               //imprimir(MergeSort.vetorAtual, MergeSort.qtdeTrocas, MergeSort.qtdeIteracoes);

                dadosColetados[0] = MergeSort.qtdeIteracoes;
                dadosColetados[1] = MergeSort.qtdeTrocas;
            }
            case 3 -> {
                // caso do grupo B (Quick Sort)
                QuickSort.qtdeIteracoes = 0;
                QuickSort.qtdeTrocas = 0;
                QuickSort.vetorAtual = vetor;

                QuickSort.sort(tamanhoVetor);

                //imprimir(QuickSort.vetorAtual, QuickSort.qtdeTrocas, QuickSort.qtdeIteracoes);

                dadosColetados[0] = QuickSort.qtdeIteracoes;
                dadosColetados[1] = QuickSort.qtdeTrocas;
            }
            case 4 -> {
                // caso do grupo C (Counting Sort)
                CountingSort.qtdeIteracoes = 0;
                CountingSort.qtdeTrocas = 0;
                CountingSort.vetorAtual = vetor;

                CountingSort.sort(tamanhoVetor);

                //imprimir(CountingSort.vetorAtual, CountingSort.qtdeTrocas, CountingSort.qtdeIteracoes);

                dadosColetados[0] = CountingSort.qtdeIteracoes;
                dadosColetados[1] = CountingSort.qtdeTrocas;
            }
            default ->
                System.out.println("tente de novo!");
        }

        return dadosColetados;
    }

    public static void imprimir(int[] vetor, int qtdeTrocas, int qtdeIteracoes) {
        System.out.print("Lista ordenada: ");

        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println("| Qtde de trocas: " + qtdeTrocas + "| Qtde de iterações: " + qtdeIteracoes);
    }
}