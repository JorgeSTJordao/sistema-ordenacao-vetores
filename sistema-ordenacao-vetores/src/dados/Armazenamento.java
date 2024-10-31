package dados;

import java.util.Random;

public class Armazenamento {

    final private int tamanho = 5;
    final private int[][] vetores = new int[tamanho][];

    public void gerarVetoresAleatorios(int tamanhoVetor, int maxValues, Random random) {
        GeradorVetores geradorVetores = new GeradorVetores();

        for (int i = 0; i < tamanho; i++) {
            vetores[i] = geradorVetores.gerarVetor(tamanhoVetor, maxValues, random);
        }
    }

    public int[][] getVetores() {
        return vetores;
    }
}
