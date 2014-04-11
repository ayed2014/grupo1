package tp_Cola.ejercicio_3;

/**
 * Created by Nash on 10/04/14.
 */
public interface ColaDePrioridad {
    public Object dequeueElement();
    public void addElement(PriorityObject priorityObject);
    public void empty();
    public boolean isEmpty();
}
