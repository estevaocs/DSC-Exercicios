package Exercicio4;

public class Exercicio4 {

    public static final int MAX = 10;

    public static void main(String[] args) {
        for (int i = 1; i <= MAX; i++ ){
           Runnable thread = new MinhaThread(i);
            new Thread(thread).start();
        }
    }

}

