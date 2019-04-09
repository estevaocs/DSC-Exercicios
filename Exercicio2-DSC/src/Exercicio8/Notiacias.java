package Exercicio8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Notiacias implements Runnable {


    private BufferedReader reader;

    public Notiacias() throws Exception {
        File arquivo = new File("src/noticias.txt");
        FileReader file = new FileReader(arquivo);
        reader  =  new BufferedReader(file);
    }

    @Override
    public void run() {
        List<String> noticias = reader.lines().collect(Collectors.toList());
        Random r = new Random();
        while(!app.encerra) {
            System.out.println(noticias.get(r.nextInt(20)));
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
