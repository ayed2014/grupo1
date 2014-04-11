package tp_Cola.ejercicio_3.Queue;

/**
 * Created by Nash on 10/04/14.
 */
public class QueueD implements Queue {
    Nodo front;
    Nodo end;


    @Override
    public void inQueue(Object anObject) {
        if (front == null){
            front = new Nodo(anObject);
            end = front;

        } else {

            Nodo aux = new Nodo(anObject);
            end.next = aux;
            end = aux;

        }
    }

    @Override
    public void deQueue() {
        if (front!=null) {
            front = front.next;

        }
        if (front == null){
            end = null;
        }
    }

    @Override
    public Object getFront() {
        return front.element;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }
    public void empty(){
        front = null;
        end = null;
    }
}
