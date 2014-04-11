package tp_Cola.ejercicio_3.Queue;

/**
 * Created by Nash on 03/04/14.
 */
public class TesterQueueE {
    public static void main(String[] args) {
        QueueE a = new QueueE();
        a.inQueue("1");
        a.inQueue("2");
        a.inQueue("3");
        a.print();
        a.inQueue("6");
        System.out.println("------------------------------------------------------");
        a.print();
        System.out.println("******************************************");
        a.deQueue();
        a.deQueue();
        a.print();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        a.inQueue(7);
        a.inQueue(99);
        a.print();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        a.deQueue();
        a.deQueue();
        a.deQueue();
        System.out.println(a.getFront());
        System.out.println("Is empty? : " + a.isEmpty());
        a.deQueue();
        a.print();
        System.out.println("Now... It must to be empty. Is empty?: " + a.isEmpty());
        a.inQueue(4);
        a.inQueue(4);
        a.inQueue(4);
        a.inQueue(4);
        a.inQueue(4);
        a.inQueue(4);
        a.inQueue(4);
        int h =0;
        while (h < 100 ) {
            a.deQueue();
            h++;
        }
        a.print();

    }

}
