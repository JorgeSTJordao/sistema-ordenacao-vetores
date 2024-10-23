package dados;

import java.util.Random;

public class GeradorVetores {

    public int[] gerarVetor(int tamanho, int max, int min){

        Random gerador = new Random();

        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++){
            vetor[i] = gerador.nextInt(max - min + 1) + min;
        }
        return vetor;
    }
}
