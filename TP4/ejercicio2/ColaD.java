package ejercicio2;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 28/03/14
 * Time: 00:01
 * To change this template use File | Settings | File Templates.
 */
public class ColaD implements Queue {
    private Nodo comienzo;
    private Nodo finaln;
    private int length;


    @Override
    public void enqueue(Object x) {
        Nodo aux = new Nodo();
        aux.dato = x;
        //aux.sig = null;

        if(comienzo == null && finaln == null) {

            comienzo = aux;
            finaln = aux;
            length++;
        }

       else {

            finaln.sig = aux;
            finaln= aux;
            length++;
        }


    }

    @Override
    public Object deQueue() {

        Object toReturn = comienzo.dato;

        if(comienzo == finaln){

            comienzo = null;
            finaln = null;
            length--;

        }

        else {
            comienzo = comienzo.sig;
            length--;
        }


        return toReturn;

    }

    @Override
    public boolean isEmpty() {

        return (comienzo == finaln);
    }

    @Override
    public int length() {
        return length;
    }
}
