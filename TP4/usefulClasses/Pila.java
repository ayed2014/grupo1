package usefulClasses;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 19/03/14
 * Time: 07:27
 * To change this template use File | Settings | File Templates.
 */
public interface Pila {

    public void apilar(Object elemento);
    public void desapilar();
    public void vaciar();
    public Object verTope();
    public boolean esVacia();
}
