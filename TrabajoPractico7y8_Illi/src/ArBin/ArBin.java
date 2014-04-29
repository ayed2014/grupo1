package ArBin;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: alumnosfi
 * Date: 26/03/14
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class ArBin implements Serializable {
    private NodoDoble raiz;

    public ArBin() {
        raiz = null;
    }

    public ArBin(Object a){
        raiz = new NodoDoble();
        raiz.element = a;
        raiz.izq = null;
        raiz.der = null;
    }
    public ArBin(Object a, ArBin t1, ArBin t2){
        raiz = new NodoDoble();
        raiz.element = a;
        raiz.izq = t1.raiz;
        raiz.der = t2.raiz;
    }
    public boolean isEmpty() {
        return (raiz == null);
    }
    public Object getRoot(){
        if (raiz == null){
            return null;
        }
        return raiz.element;
    }

    public ArBin getLeft(){
        ArBin toReturn = new ArBin();
        toReturn.raiz = raiz.izq;
    return toReturn;
    }
    public ArBin getRight(){
        ArBin toReturn = new ArBin();
        toReturn.raiz = raiz.der;
        return toReturn;
    }

    public NodoDoble getRaiz() {
        return raiz;
    }
}
