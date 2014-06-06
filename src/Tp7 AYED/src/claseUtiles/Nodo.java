package claseUtiles;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/05/14
 * Time: 10:24
 * To change this template use File | Settings | File Templates.
 */
public class Nodo implements Serializable {
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
