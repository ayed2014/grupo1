package tp_Cola.ejercicio_3;


import tp_Cola.ejercicio_3.Queue.QueueD;

/**
 * Created by Nash on 10/04/14.
 */
public class PriorityQueue implements ColaDePrioridad {
    private QueueD[] queues;

    public PriorityQueue(int quantityOfPriorities) {
        if (quantityOfPriorities<0) {
            quantityOfPriorities = -quantityOfPriorities;
        }
        queues = new QueueD[quantityOfPriorities];
        for (int i = 0; i<quantityOfPriorities;i++){
            queues[i] = new QueueD();
        }
    }
    public boolean isEmpty() {
        for (QueueD queueD : queues) {
            if (!queueD.isEmpty()){
                return false;
            }
        }
        return true;
    }
    public void empty() {
        for (QueueD queueD : queues){
            queueD.empty();
        }
    }
    public void addElement(PriorityObject priorityObject) {
        try {
            queues[priorityObject.getPriority() - 1].inQueue(priorityObject);
        }catch (Exception ex) {
            queues[queues.length - 1].inQueue(priorityObject);
        }
    }
    public Object dequeueElement() {
        for (int i = 0; i<queues.length; i++){
            try {
                Object toReturn = queues[i].getFront();
                queues[i].deQueue();
                return toReturn;
            } catch (Exception a) {

            }
        }
        return null;
    }
}
