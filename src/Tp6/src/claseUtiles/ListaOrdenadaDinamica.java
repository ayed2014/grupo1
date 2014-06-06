package claseUtiles;



import javax.xml.soap.Node;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 11/04/14
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
public class ListaOrdenadaDinamica implements Serializable {

    private Nodo window;
    private Nodo cabecera;
    private Nodo centinela;
    private int quantity;

    public ListaOrdenadaDinamica(){
        cabecera=new Nodo();
        centinela=new Nodo();
        window=cabecera;
        cabecera.next=centinela;
    }

    public void insert(Object x){
        if (x instanceof Comparable)
            insert((Comparable)x);
        else
            System.out.println("The Object is not Comparable");
    }
    public void insert(Comparable x){
        window = cabecera;
        try {
            while (window.next.elem.compareTo(x) <= 0) {
                window = window.next;
            }
        } catch (NullPointerException ignored){}
        window.next = new Nodo(x, window.next);
        window = window.next;
        quantity++;
    }
    public void next() {
        if (window.next.next!=null)
            window=window.next;
    }
    public void before() {
        if (window != cabecera.next) {
            Nodo aux = cabecera;
            while (window != aux.next) {
                aux = aux.next;
            }
            window = aux;
        }
    }
    public void goTo(int index) {
        window = cabecera.next;
        for(int i = 0; i < index; i++){
            window = window.next;
        }
    }
    public boolean isEmpty() {
        return (cabecera.next==null);
    }
    public void empty() {
        cabecera.next=centinela;
    }
    public Object showWindow() {
        return window.elem;
    }
    public void delete() {
        if(isEmpty()) throw new NullPointerException("This List is empty");
        before();
        window.next = window.next.next;
        window = window.next;
        if(window == centinela) before();
        quantity--;
    }
    public void modify(Comparable elem) {
        window.elem=elem;
    }
    public void isFirst(){
        window=cabecera.next;
    }
    public int length() {
        return quantity;
    }

}


