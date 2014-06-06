package arboles;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/04/14
 * Time: 12:16
 * To change this template use File | Settings | File Templates.
 */
public class ArBin implements Serializable {

    private NodoDoble raiz;


    public ArBin(){
        raiz = null;
    }

    public ArBin(Object x){
        raiz = new NodoDoble();
        raiz.elem = x;
        raiz.izq = null;
        raiz.der = null;
    }

    public ArBin(Object x, ArBin t1, ArBin t2){
        raiz = new NodoDoble();
        raiz.elem = x;
        raiz.izq = t1.raiz;
        raiz.der = t2.raiz;
    }

    public boolean esVacio(){
        return (raiz == null);
    }

    public Object getRoot(){
        return raiz.elem;
    }

    public ArBin hijoIzq(){
        ArBin t = new ArBin();
        t.raiz = raiz.izq;
        return t;
    }

    public ArBin hijoDer(){
        ArBin t = new ArBin();
        t.raiz = raiz.der;
        return t;
    }


}
