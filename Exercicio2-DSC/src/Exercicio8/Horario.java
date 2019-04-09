package Exercicio8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Horario implements Runnable {

    @Override
    public void run() {
        DateFormat formato = new SimpleDateFormat("HH:mm:ss.SSS");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(formato.format(new Date()));
                Thread.sleep(10000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
