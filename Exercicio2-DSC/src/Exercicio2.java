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
        Integer max = 0;
        String maior = null;
        try  {
            FileReader file = new FileReader(arquivo);
            BufferedReader reader =  new BufferedReader(file);
            for (String s : reader.lines().collect(Collectors.toList())) {
                if (!s.isEmpty()) {
                    Integer num = Integer.parseInt(s);
                    if (num.compareTo(Integer.valueOf(255)) <= 0) {
                        //System.out.println(s);
                        if(map.get(s) == null) {
                            map.put(s,Integer.valueOf(1));
                        } else {
                            Integer m = map.get(s);
                            map.put(s, m+1);
                            if (max.compareTo(m+1) == 1) {
                                max = m+1;
                                maior = s;
                            }
                        }
                    }
                }
            }
            System.out.println(map.);

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }
}
