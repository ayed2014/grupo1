package usefullClasses;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 16/04/14
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
public class ArBinBus {

    private NodoDoble raiz;
    public ArBinBus(){
        raiz = null;
    }
    // precondicion: elemento a insertar no pertenece al árbol
    public void insertar(Comparable x){
        raiz = insertar(raiz, x);
    }
    // precondicion: elemento a eliminar pertenece al árbol
    public void eliminar(Comparable x){
        raiz = eliminar(raiz, x);
    }
    // precondicion: árbol distinto de vacío
    public Object getMin(){
        return getMin(raiz).elem;
    }
    // precondicion: árbol distinto de vacío
    public Object getMax(){
        return getMax(raiz).elem;
    }
    // precondicion: elemnto a buscar pertenece al arbol
    public Object buscar(Comparable x){
        return buscar(raiz, x).elem;
    }
    // precondicion: -
    public boolean existe(Comparable x){
        return existe(raiz, x);
    }
    // precondicion: -
    public boolean esVacio(){
        return (raiz == null);
    }
    // precondición: árbol distino de vacío
    public Object getRaiz(){
        return raiz.elem;
    }
    // precondición: árbol distino de vacío
    public ArBinBus hijoIzq(){
        ArBinBus t = new ArBinBus();
        t.raiz = raiz.izq;
        return t;
    }
    // precondición: árbol distino de vacío
    public ArBinBus hijoDer(){
        ArBinBus t = new ArBinBus();
        t.raiz = raiz.der;
        return t;
    }
    // METODOS PRIVADOS
    private NodoDoble getMax(NodoDoble t){
        if (t.der == null)
            return t;
        else
            return getMax(t.der);
    }
    private NodoDoble getMin(NodoDoble t){
        if (t.izq == null)
            return t;
        else
            return getMin(t.izq);
    }
    private NodoDoble buscar(NodoDoble t, Comparable x){
        if (x.compareTo( t.elem)== 0)
            return t;
        else if (x.compareTo( t.elem)< 0)
            return buscar(t.izq, x);
        else
            return buscar(t.der, x);
    }
    private boolean existe(NodoDoble t, Comparable x) {
        if (t == null)
            return false;
        if (x.compareTo(t.elem) == 0)
            return true;
        else if (x.compareTo( t.elem)< 0)
            return existe(t.izq, x);
        else
            return existe(t.der, x);
    }

    private NodoDoble insertar (NodoDoble t, Comparable x) {
        if (t == null){
            t = new NodoDoble();
            t.elem = x;
        }
        else if (x.compareTo(t.elem) < 0)
            t.izq = insertar(t.izq, x);
        else
            t.der = insertar(t.der, x);
        return t;
    }
    private NodoDoble eliminar (NodoDoble t, Comparable x) {
        if (x.compareTo(t.elem) < 0){
            t.izq = eliminar(t.izq, x);
        }
            else if (x.compareTo(t.elem) > 0) {

                t.der = eliminar(t.der, x);
        }
            else{

            if (t.izq != null && t.der != null ) {
                t.elem = getMin(t.der).elem;
                t.der = eliminarMin(t.der);
            }

            else if (t.izq != null) {
                t = t.izq;
           }
            else{
                t =t.der;
           }
        }
            return t;
    }

    private NodoDoble eliminarMin(NodoDoble t){
        if (t.izq != null)
            t.izq = eliminarMin(t.izq);
        else
            t = t.der;
        return t;
    }



}
