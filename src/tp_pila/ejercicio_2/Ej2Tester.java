package tp_pila.ejercicio_2;

import java.io.File;

/**
 * Created by Nash on 20/03/14.
 */
public class Ej2Tester {
    public static void main(String[] args) {
        File c = new File("text.txt");

        if (Ej2.analizador(c)){
        System.out.println("El texto es correcto.");
        }
        else {
            System.out.println("El texto tiene uno o más errores.");
        }
    }
}
