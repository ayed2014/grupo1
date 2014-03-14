package pila;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 14/03/14
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 */
public class PilaTester3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        PilaE miPila= new PilaE();
        boolean continuar= true;
        while(continuar){
            int opcion= Integer.parseInt(br.readLine());
            switch (opcion){
                case 1:
                    System.out.println("ingrese el numero");
                    int dato= Integer.parseInt(br.readLine()) ;
                    miPila.apilar(dato);
                    break;
                case 2:
                    miPila.desapilar();
                    break;
                case 3:
                    miPila.desapilar();
                    System.out.println("ingrese un dato");
                    int dato2=Integer.parseInt(br.readLine());
                    miPila.apilar(dato2);
                    break;
                case 4:
                    System.out.println(miPila.verTope());
                    break;
                case 5:
                    continuar=false;
            }
        }
    }
}
