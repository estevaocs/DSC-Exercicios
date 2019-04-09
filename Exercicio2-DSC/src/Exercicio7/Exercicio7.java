package Exercicio7;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Exercicio7 {


    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int[][] matriz;
        int linhas = 0;
        int colunas = 0;

        try {
            System.out.println("Digite a quantidade de linhas:");
            linhas = Math.abs(sc.nextInt());
            System.out.println("Digite a quantidade de colunas:");
            colunas = Math.abs(sc.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Valor informado é inválido. Executar novamente.");
            System.exit(0);
        }

        matriz = new int[linhas][colunas];

        long tempoIniValores = System.currentTimeMillis();
        gerandoMatriz(matriz, linhas, colunas);
        long tempoTotValores = System.currentTimeMillis() - tempoIniValores;

        imprimeMatriz(matriz, linhas, colunas);

        // Cria array de threads
        Thread[] threads = new Thread[linhas];
        T1[] runnables = new T1[linhas];

        // Inicia as threads
        long tempoIniCalculo =  System.currentTimeMillis();
        instaciaArrayThread(matriz, linhas, threads, runnables);
        // Espera a execução das threads finalizar
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long tempoTotCalculo = System.currentTimeMillis() - tempoIniCalculo;

        // Imprime resultados
        imprimeResultados(tempoTotValores, runnables, tempoTotCalculo);
    }

    private static void imprimeResultados(long tempoTotValores, T1[] runnables, long tempoTotCalculo) {
        int somaTotal = 0;
        System.out.print(System.lineSeparator());
        for (int i = 0; i < runnables.length; i++) {
            long somaParcial = runnables[i].getSoma();
            somaTotal += somaParcial;
            System.out.println("Soma da linha " + (i + 1) + ": " + somaParcial);
        }
        System.out.println("Soma total: " + somaTotal);
        System.out.println("\nTempo decorrido p/ gerar valores (ms): " + tempoTotValores);
        System.out.println("Tempo decorrido p/ calcular (ms): " + tempoTotCalculo);
    }

    private static void instaciaArrayThread(int[][] matriz, int linhas, Thread[] threads, T1[] runnables) {
        for (int i = 0; i < linhas; i++) {
            runnables[i] = new T1(matriz[i]);
            threads[i] = new Thread(runnables[i]);
            threads[i].start();
        }
    }

    private static void imprimeMatriz(int[][] matriz, int linhas, int colunas) {
        System.out.println("\nMatriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (j != 0) {
                    System.out.print("\t");
                }
                System.out.print(matriz[i][j]);
            }
            System.out.print(" " + System.lineSeparator());
        }
    }

    private static void gerandoMatriz(int[][] matriz, int linhas, int colunas) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(1, 100);
            }
        }
    }

    private static class T1 implements  Runnable {
        private int[] linha;
        private long soma = 0;

        T1(int[] linha) {
            this.linha = linha;
        }

        long getSoma() {
            return this.soma;
        }

        @Override
        public void run() {
            for (int num : this.linha) {
                soma += num;
            }
        }
    }
}
