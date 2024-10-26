import dados.Armazenamento;
import grupoB.mergeSort.MergeSort;

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
            ordenar(2, vetores[i], tamanhoVetor);
        }
    }

    public static void ordenar(int codigo, int[] vetor, int tamanhoVetor){
        switch (codigo) {
            case 1 -> {
                //CaseA
            }
            case 2 -> {
                //CaseB1
                MergeSort.separar(vetor, tamanhoVetor, tamanhoVetor);
            }
            case 3 -> {
                //CaseB2
            }
            case 4 -> {
                //CaseC
            }
            default -> {
                System.out.println("Tente de novo!");
            }
        }
    }
}