package lista_ordenada;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 11/04/14
 * Time: 10:40
 * To change this template use File | Settings | File Templates.
 */
public class ListaOrdenadaDinamica {

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
        Nodo nuevo = new Nodo();
        Nodo aux = cabecera.next;
        while (aux.next!=null){
            if (x.compareTo((Comparable)aux.next.elem )<0){
                nuevo.next=aux.next;
                aux.next =nuevo;
                break;
            }else aux = aux.next;
        }
        if (aux.next==nuevo){
            aux.next=nuevo;
        }
    }
    public void next() {
        if (window.next.next!=null)
            window=window.next;
    }
    public void before() {
        Nodo before= new Nodo();
        Nodo aux;
        aux=cabecera.next;
        while(aux!=window){
            before=aux;
            aux=aux.next;
        }
        window=before;
    }
    public void goTo(int x) {

    }
    public boolean isEmpty() {
        return (quantity==0);
    }
    public void empty() {
        cabecera.next=centinela;
    }
    public Object showWindow() {
        return window.elem;
    }
    public void delete() {
        if (quantity!=0){
            window.elem=window.next.elem;
            window.next=window.next.next;
            quantity--;
        }
        if (window.equals(centinela))
            before();
    }
    public void modify(Object elem) {
        window.elem=elem;
    }
    public void isFirst(){
        window=cabecera.next;
    }
    public int length() {
        return quantity;
    }

}


