package tp_Cola;

import cola.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 28/03/14
 * Time: 10:16
 * To change this template use File | Settings | File Templates.
 */
public class QueueE implements Queue {
    private int amount;
    private int front;
    private int end;
    private Object[] datos;

    public QueueE(){
        datos= new Object[2];
        amount=front=end=0;
    }
    @Override
    public void enqueue(Object o) {
       if (amount==datos.length){
           resize();
           front=0;
           end=amount;
       }
        datos[end]=o;
        if (end==(datos.length-1)){
            end=0;
        }else end++;
        amount++;
    }

    @Override
    public Object dequeue() {
        Object auxiliar=datos[front];
        if (front==(datos.length-1)){
            front=0;
        }else front++;
        amount--;
        return auxiliar;
    }

    @Override
    public boolean isEmpty() {
        return (amount==0);
    }

    @Override
    public int length() {
        return amount;
    }

    @Override
    public Object seeFront() {
        return datos[front];
    }

    private void resize(){
        Object []aux= new Object[datos.length+10];
        if (front >=end){
            int j = 0;
            for (int i = front; i<datos.length;i++){
                aux[j]=datos[i];
                j++;
            }
            for (int k=0; k<end;k++){
                aux[j]=datos[k];
                j++;
            }
        }else {
            int j=0;
            for (int i =front;i<end;i++){
                aux[j]=datos[i];
                j++;
            }
        }
        datos=aux;
    }
}
