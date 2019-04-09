package Exercicio8;

public class app {

    public static boolean encerra = false;

    public static void main(String[] args) {
        try {
            Thread noticias = new Thread(new Notiacias());
            Thread horario = new Thread(new Horario());
            noticias.start();
            horario.start();

            while(!encerra) {
                if (!horario.isAlive()) encerra = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
