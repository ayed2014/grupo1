package tp_Cola.ejercicio_1;

import tp_Cola.QueueD;
import tp_pila.PilaE;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 02/04/14
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public class Palindromo {

    public static boolean isPalindromo(String str){
        PilaE p= new PilaE();
        QueueD qd = new QueueD();
        for (int i = 0; i < str.length(); i++) {
            p.apilar(str.charAt(i));
            qd.enqueue(str.charAt(i));
        }
        while (!p.esVacia()){
            if (p.verTope().equals(qd.seeFront())){
                p.desapilar();
                qd.dequeue();
            }else{
                return false;
            }
        }
        return true;
    }

}
