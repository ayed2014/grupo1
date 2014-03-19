package tp_pila.ejercicio_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 19/03/14
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
public class EstacionamientoTester {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        Estacionamiento est= new Estacionamiento();
        boolean continuar= true;
        System.out.println("Opciones: \n"+"Ingrese 1 para agregar auto\n"+"Ingrese 2 para quitar auto\n"+
                "Ingrese 3 para ver la recaudación\n"+"Ingrese 4 para salir\n");
        while (continuar){
            System.out.println("ingrese la opcion elegida: ");
            int opcion= Integer.parseInt(br.readLine());
            switch (opcion){
                case 1:
                    System.out.println("Ingrese la patente del auto");
                    String patente= br.readLine() ;
                    est.agregarAuto(new Auto(patente));
                    break;
                case 2:
                    System.out.println("Ingrese la patente del auto a retirar");
                    String patenteASacar= br.readLine() ;
                    est.quitarAuto(new Auto(patenteASacar));
                    break;
                case 3:
                    est.printRecaudado();
                    break;
                case 4:
                    continuar=false;
            }
        }
    }
}
