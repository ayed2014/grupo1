package tp_Cola.ejercicio_3.Queue;

/**
 * Created by Nash on 03/04/14.
 */
class QueueE implements Queue {
    int front = -1;
    int back = -1;
    int quantity=0;
    Object[] data;

    QueueE() {
        this.data = new Object[5];
    }

    public Object getFront() {
        return data[front];
    }

    public boolean isEmpty() {
        return (quantity==0);
    }

    public void inQueue(Object a) {
        if (front == -1) {

            front = 0;
        }
        if (quantity==data.length) {
            reSize();
        }
        back++;
        if (back == data.length){
            back =0;
        }
        data[back] = a;
        quantity++;

    }
    public void deQueue() {
        if (!isEmpty()) {
            data[front] = null;
            front++;
            if (front == data.length) {
                front = 0;
            }
            quantity--;
        }
       else {              // TODO   -> Me deberin quedar por lo menos iguales automaticamete.
            front = -1;
            back = -1;
        }
    }
    private void incrementar(int x){

    }
    public void print(){
        if (!isEmpty()) {
            if (back > front) {
                for (int i = front; i <= back; i++) {
                    System.out.println(data[i]);
                }
            } else {
                for (int i = front; i < data.length; i++) {
                    System.out.println(data[i]);
                }
                for (int e = 0; e <= back; e++) {
                    System.out.println(data[e]);
                }
            }
        }
        else {
            System.out.println("It's empty");
        }

    }
    public void reSize() {

        Object[] data2 = new Object[data.length + 2];
        int i = 0;
        if (back < front){
            for (int b = data.length - 1; b>front; b--,i++){
                data2[i] = data[b];
            }
            for (int a = 0 ; a<back; a++, i++) {
                data2[i] = data[a];
            }
            back = quantity-1;
        }
        else {
            for (int a = front; a<=back; a++, i++) {
                data2[i] = data[a];
            }
            back = quantity-1;
        }
        data = data2;
    }
}
