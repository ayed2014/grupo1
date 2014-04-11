package tp_Cola.ejercicio_3;

/**
 * Created by Nash on 10/04/14.
 */
public class TesterPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(3);

        PriorityObject joven1 = new PriorityObject(3);
        PriorityObject embarazada1 = new PriorityObject(1);
        PriorityObject señorMayor1 = new PriorityObject(2);
        PriorityObject embarazada2 = new PriorityObject(1);
        PriorityObject discapacitado1 = new PriorityObject(1);
        PriorityObject señorMayor2 = new PriorityObject(2);
        PriorityObject embarazada3 = new PriorityObject(1);
        PriorityObject adulto1 = new PriorityObject(5);
        PriorityObject joven2 = new PriorityObject(3);
        PriorityObject embarazada4 = new PriorityObject(1);


        PriorityObject[] priorityObjects = {adulto1,embarazada1,señorMayor1,embarazada2,discapacitado1,señorMayor2,embarazada3,joven1,joven2,embarazada4};

        for (PriorityObject priorityObject : priorityObjects) {
            priorityQueue.addElement(priorityObject);
        }

        Boolean isEmpty = priorityQueue.isEmpty();

        Object dequeue1 = priorityQueue.dequeueElement();
        Object dequeue2 = priorityQueue.dequeueElement();
        Object dequeue3 = priorityQueue.dequeueElement();
        priorityQueue.empty();
        Object dequeue4 = priorityQueue.dequeueElement();
        Object dequeue5 = priorityQueue.dequeueElement();
        Object dequeue6 = priorityQueue.dequeueElement();
        Object dequeue7 = priorityQueue.dequeueElement();
        priorityQueue.addElement(adulto1);
        priorityQueue.addElement(señorMayor1);
        Object dequeue8 = priorityQueue.dequeueElement();
        Object dequeue9 = priorityQueue.dequeueElement();

        isEmpty = priorityQueue.isEmpty();


    }
}
