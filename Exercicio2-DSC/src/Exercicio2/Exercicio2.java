package Exercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aluno on 02/04/19.
 */
public class Exercicio2 {
    public static void main(String[] args) {
        File arquivo = new File("src/numeros.txt");
        HashMap<String,Integer> map = new HashMap<>();
        List<String> maiores = new ArrayList();
        Integer max = 0;
        try  {
            FileReader file = new FileReader(arquivo);
            BufferedReader reader =  new BufferedReader(file);
            for (String s : reader.lines().collect(Collectors.toList())) {
                if (!s.isEmpty()) {
                    Integer num = Integer.parseInt(s);
                    if (num.compareTo(Integer.valueOf(255)) <= 0) {
                        Integer x = map.get(s);
                        if(x == null) {
                            map.put(s,Integer.valueOf(1));
                            Integer m = map.get(s);
                            int n = max.compareTo(m);
                            if (n < 0) {
                                max = m;
                                maiores = new ArrayList<>();
                                maiores.add(s);
                            } else if (n == 0) {
                                max = m;
                                maiores.add(s);
                            }
                        } else {
                            Integer m = map.get(s);
                            map.put(s, m+1);
                            int n = max.compareTo(m+1);
                            if (n < 0) {
                                max = m+1;
                                maiores = new ArrayList<>();
                                maiores.add(s);
                            } else if (n == 0) {
                                max = m+1;
                                maiores.add(s);
                            }
                        }
                    }
                }
            }
            System.out.printf("os numeros que mais se repetiram são: ");
           maiores.forEach(s -> System.out.printf(s +", "));
            System.out.print("\nrepetindo: " + max);

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }
}
