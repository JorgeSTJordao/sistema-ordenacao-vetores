import dados.Armazenamento;
import grupoB.mergeSort.MergeSort;
import grupoA.InsertSort.InsertSort;
import grupoC.CountingSort.CountingSort;


//Inicio do programa
public class Main {
    public static void main(String[] args) {
        int tamanhoVetor = 10; //Quantidade de itens no vetor:  1000, 10000, 100000, 500000, 1000000
        int maxValues = 100; //Randomização desde o valor zero até "maxValues" (sempre números naturais)

        Armazenamento armazenamento = new Armazenamento();

        armazenamento.gerarVetoresAleatorios(tamanhoVetor, maxValues);

        int[][] vetores =  armazenamento.getVetores();

        //Sempre será gerado 5 vetores, pois precisamos de no mínimo 5 para o cálculo da média
        for (int i = 0; i < 5; i++){
            //Aqui podemos selecionar a ordenação que desejamos
            ordenar(1, vetores[i], tamanhoVetor);
        }
    }

    public static void ordenar(int codigo, int[] vetor, int tamanhoVetor){
        switch (codigo) {
            case 1 -> {
                // caso do grupo A (Insert Sort)
                InsertSort.sort(vetor);
            }
            case 2 -> {
                // caso do grupo B (já implementado)
                MergeSort.separar(vetor, tamanhoVetor, tamanhoVetor);
            }
            case 3 -> {
                // segundo caso do grupo B (se houver)
            }
            case 4 -> {
                // caso do grupo C (Counting Sort)
                CountingSort.sort(vetor);
            }
            default -> {
                System.out.println("tente de novo!");
            }
        }
    }
}