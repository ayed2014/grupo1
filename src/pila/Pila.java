package pila;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 14/03/14
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
public interface Pila {

    public void apilar(Object elemento);
    public void desapilar();
    public void vaciar();
    public Object verTope();
    public boolean esVacia();

}
