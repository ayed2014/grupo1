package tp_pila.ejercicio_3;
import tp_pila.PilaE;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 18/03/14
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
public class Estacionamiento {
    private PilaE lugar;
    private PilaE calle;
    private int cantidadDeAutos=0;
    private int recaudado=0;

    public Estacionamiento(){
        lugar=new PilaE(50);
        calle= new PilaE();
    }

    public void agregarAuto(Auto auto){
        if(cantidadDeAutos<50){
            lugar.apilar(auto);
            cantidadDeAutos++;
        }else System.out.println("No hay lugar en el estacionamiento");
    }
    public void quitarAuto(Auto auto){
        if (!lugar.esVacia()){
            Auto auto2= (Auto)lugar.verTope();
            while (auto.compareTo(auto2)==1){
                calle.apilar(auto2);
                lugar.desapilar();
                auto2=(Auto) lugar.verTope();
            }
            lugar.desapilar();
            while (!calle.esVacia()){
                lugar.apilar(calle.verTope());
                calle.desapilar();
            }
            cantidadDeAutos--;
            recaudado=recaudado+5;
        }  else System.out.println( "No hay autos en el estacionamiento");

    }
    public void printRecaudado(){
        System.out.println("En el día se recaudo: "+ recaudado +" pesos.");
    }
}
