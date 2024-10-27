package grupoA.InsertSort;

public class InsertSort {
    public static void sort(int[] vetor) {
        // realiza a ordenacao
        for (int i = 1; i < vetor.length; i++) {
            int key = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = key;
        }
        // imprime o vetor ordenado
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
