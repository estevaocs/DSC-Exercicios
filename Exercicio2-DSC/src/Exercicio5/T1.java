package Exercicio5;

import Exercicio4.Exercicio4;

public class T1 implements Runnable {

    private int num;

    public T1(int num) {
        this.num = num;
    }

    public void run() {
        for (int i = 0; i < Exercicio4.MAX; i++)
            System.out.println("Thread " + num + " executando");
    }
}
