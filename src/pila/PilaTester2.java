package pila;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 14/03/14
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public class PilaTester2 {
    public static void main(String[] args) {

        PilaE pila1= new PilaE();
        PilaE pila2= new PilaE();

        for (int i = 0; i < 5; i++) {
            pila1.apilar(i);
        }
        while (!pila1.esVacia()){
            pila2.apilar(((Integer)pila1.verTope())*2);
            pila1.desapilar();
        }
        while(!pila2.esVacia()){
            System.out.println(pila2.verTope());
            pila2.desapilar();
        }
    }
}
