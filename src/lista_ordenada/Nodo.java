package lista_ordenada;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 11/04/14
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 */
public class Nodo {
    Comparable elem;
    Nodo next;
    public Nodo(){

    }
    public Nodo(Comparable elem){
        this.elem=elem;
    }
    public Nodo(Comparable elem, Nodo next){
        this.elem=elem;
        this.next=next;
    }

}
