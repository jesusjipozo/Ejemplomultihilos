import java.util.Random;

public class Coche implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private static final int DISTANCIA_META = 100;
    private static boolean ganadorAnunciado = false; // Para detectar el ganador

    public Coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (distanciaRecorrida < DISTANCIA_META && !ganadorAnunciado) {
            int avance = random.nextInt(10) + 1; // Avance aleatorio entre 1 y 10
            distanciaRecorrida += avance;

            System.out.println(nombre + " ha avanzado " + avance + " unidades. Total: " + distanciaRecorrida);

            if (distanciaRecorrida >= DISTANCIA_META && !ganadorAnunciado) {
                ganadorAnunciado = true;
                System.out.println(nombre + " ha ganado la carrera!");
            }

            try {
                Thread.sleep(500); // Pausa de medio segundo entre avances
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
