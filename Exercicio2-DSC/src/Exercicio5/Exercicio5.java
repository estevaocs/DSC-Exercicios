package Exercicio5;

import java.util.ArrayList;
import java.util.List;

public class Exercicio5 {

    public static final int MAX = 5;

    public static void main(String[] args) {
        List<Runnable> matriz = new ArrayList<>();
        for (int i = 1; i <= MAX; i++ ){
           Runnable thread = new T1(i);
           matriz.add(thread);
        }
        matriz.forEach(r -> new Thread(r).start());
    }

}

