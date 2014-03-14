package pila;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 14/03/14
 * Time: 13:55
 * To change this template use File | Settings | File Templates.
 */
public class PilaTester4 {

    public static void main(String[] args) {

    PilaE pila1= new PilaE();
    PilaE pila2= new PilaE();
    PilaE pila3 = new PilaE();
    PilaE pila4 = new PilaE();

        for (int i = 0; i < 5; i++) {
            pila1.apilar((int)((Math.random())*20));
            pila2.apilar((int)((Math.random())*20));
        }
        for (int j=0; j<5;j++){
            pila3.apilar(pila1.verTope());
            pila1.desapilar();
            pila3.apilar(pila2.verTope());
            pila2.desapilar();
        }
        for (int k = 0; k < 10; k++) {
            pila4.apilar(pila3.verTope());
            pila3.desapilar();
        }
        for (int l = 0; l < 10; l++) {
            System.out.println(pila4.verTope());
            pila4.desapilar();
        }
    }
}
