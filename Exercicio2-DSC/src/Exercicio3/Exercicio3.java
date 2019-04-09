package Exercicio3;

import java.util.ArrayList;
import java.util.List;


public class Exercicio3 {

    public static final int MAX = 300_000;

    public static void main(String[] args) {
        long inicio, fim;
        inicio = System.currentTimeMillis();
        for (int j = 0; j <= MAX; j++) {
            List<Integer> primos = new ArrayList<>();

            boolean isPrimo = true;
            int divisor = 0;
            for (int i = 2; i <= j; i++) {
                if (((j % i) == 0) && (i != j)) {
                    isPrimo = false;
                    divisor = i;
                    break;
                }
            }
            if (isPrimo) {
                System.out.println(j);
            }
        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto: " + (fim - inicio) + " milisegundos");
    }
}
