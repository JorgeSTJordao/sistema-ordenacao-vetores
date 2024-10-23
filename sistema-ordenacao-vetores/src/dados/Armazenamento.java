package dados;

public class Armazenamento {

    final private int[][] vetores = new int[1][];
    final private int[] tamanhos = {10};

    public void gerarVetoresAleatorios(){
        GeradorVetores geradorVetores = new GeradorVetores();

        for (int i = 0; i < 1; i++){
            vetores[i] = geradorVetores.gerarVetor(tamanhos[i], tamanhos[i], -1*tamanhos[i]);
        }
    }

    public int[][] getVetores(){
        return vetores;
    }
}
