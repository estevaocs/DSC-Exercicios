package Exercicio6;

import Exercicio6.Contador;

import java.util.ArrayList;
import java.util.List;

public class TesteContador {

    public static final int MAX = 5;

    public static void main(String[] args) {
        List<Runnable> list = new ArrayList<>();
        for (int i = 1; i <= MAX; i++ ){
            Runnable thread = new Contador();
            list.add(thread);
        }
        list.forEach(r -> new Thread(r).start());
    }

}

