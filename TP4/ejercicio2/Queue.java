package ejercicio2;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 27/03/14
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
public interface Queue {

    void enqueue(Object x);
    Object deQueue();
    boolean isEmpty();
    int length();
}
