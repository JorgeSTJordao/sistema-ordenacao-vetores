import dados.Armazenamento;

//Inicio do programa
public class Main {
    public static void main(String[] args) {
        Armazenamento armazenamento = new Armazenamento();

        armazenamento.gerarVetoresAleatorios();

        int[][] vetor =  armazenamento.getVetores();

        for (int i = 0; i < 10; i++){
            System.out.print(vetor[0][i] + ", ");
        }
    }
}