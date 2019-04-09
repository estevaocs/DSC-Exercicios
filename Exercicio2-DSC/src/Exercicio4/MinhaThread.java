package Exercicio4;

public class MinhaThread implements Runnable {

    private int num;

    public MinhaThread(int num) {
        this.num = num;
    }

    public void run() {
        for (int i = 0; i < Exercicio4.MAX; i++)
        System.out.println(num);
    }
}
