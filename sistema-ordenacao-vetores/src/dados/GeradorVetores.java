package dados;

import java.util.Random;

public class GeradorVetores {

    public int[] gerarVetor(int tamanhoVetor, int maxValues){

        Random gerador = new Random();

        int[] vetor = new int[tamanhoVetor];

        for (int i = 0; i < tamanhoVetor; i++){
            vetor[i] = gerador.nextInt(maxValues);
        }
        return vetor;
    }
}
