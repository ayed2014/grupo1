package tp_Cola.ejercicio_3.Queue;

/**
 * Created by Nash on 03/04/14.
 */
public interface Queue {
    void inQueue(Object anObject);
    void deQueue();
    Object getFront();
    boolean isEmpty();
}
