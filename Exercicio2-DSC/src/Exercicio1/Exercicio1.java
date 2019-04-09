package Exercicio1;

public class Exercicio1 {

    public static void main(String[] args) {
        long inicio, fim;
        double tempo;
        inicio = System.currentTimeMillis();
        boolean positivo = false;
        double  pi = 1, aux = 3;
        for (int i = 0; i < 10000; i++) {
            if (positivo) {
                pi = pi + (1 / aux);
            } else {
                pi = pi - (1 / aux);
            }
            positivo = !positivo;
            aux = aux + 2;
        }
        pi = pi * 4;
        fim = System.currentTimeMillis();
        tempo = fim - inicio;
        System.out.println("pi: " + pi);
        System.out.println("tempo: " + tempo);
    }
}
