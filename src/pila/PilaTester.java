package pila;


/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 14/03/14
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */
public class PilaTester {
    public static void main(String[] args) {
        PilaE miPila= new PilaE();
        for (int i = 1; i < 6 ;i++) {
            miPila.apilar(i);
        }
        while(!miPila.esVacia()){
            System.out.println(miPila.verTope());
            miPila.desapilar();
        }
    }
}
