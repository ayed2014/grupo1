package tp_Cola;


/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 28/03/14
 * Time: 11:58
 * To change this template use File | Settings | File Templates.
 */
public class QueueD implements Queue {
    Nodo end;
    Nodo front;
    int cuantity;

    public QueueD(){
        cuantity=0;
    }
    @Override
    public void enqueue(Object o) {
        if (isEmpty()){
            front=new Nodo();
            front.dato=o;
            front.sig=null;
            end=front;
        }else {
            Nodo aux= new Nodo();
            aux.dato=o;
            aux.sig=null;
            end.sig=aux;
            end=end.sig;
        }

        cuantity++;
    }

    @Override
    public Object dequeue() {
        Object elem= front.dato;
        Nodo aux=front.sig;
        front=aux;
        cuantity--;
        return elem;
    }

    @Override
    public boolean isEmpty() {
        return (cuantity==0);
    }

    @Override
    public int length() {
        return cuantity;
    }

    @Override
    public Object seeFront() {
        return front.dato;
    }

}
