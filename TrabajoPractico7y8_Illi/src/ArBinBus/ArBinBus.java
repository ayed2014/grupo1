package ArBinBus;

public class ArBinBus {
    private NodoDoble root;

    public Object getRaiz(){
        return root.element;
    }
    public ArBinBus getLeft(){
        ArBinBus toReturn = new ArBinBus();
        toReturn.root = root.izq;
        return toReturn;
    }
    public ArBinBus getRight() {
        ArBinBus toReturn = new ArBinBus();
        toReturn.root = root.der;
        return toReturn;
    }
    public NodoDoble getRoot() {
        return root;
    }
    public boolean isEmpty() {
        return root == null;
    }
    public ArBinBus() {
        root = new NodoDoble();
    }
    public void insertar(Comparable comparable){

       if (!existe(comparable)){
           root = insertar(root,comparable);
       }

    }  // exception
    private NodoDoble insertar(NodoDoble a, Comparable comparable){
        if (a==null){
            a = new NodoDoble();
            a.element = comparable;
        }
        else if (comparable.compareTo(a.element) > 0) {
            a.der = insertar(a.der,comparable);
        }
        else {
            a.izq = insertar(a.izq,comparable);
        }
        return a;
    }
    public void eliminar(Comparable comparable){
        root = eliminar(root,comparable);
    }
    private NodoDoble eliminar(NodoDoble nodoDoble, Comparable comparable) {
        if (comparable.compareTo(nodoDoble.element) < 0) {
            nodoDoble.izq = eliminar(nodoDoble.izq, comparable);
        }
        else if (comparable.compareTo(nodoDoble.element) > 0) {
            nodoDoble.der = eliminar(nodoDoble.der, comparable);
        }
        else {
            if (nodoDoble.izq != null && nodoDoble.der != null) {
               nodoDoble.element = getMin(nodoDoble.der).element;
               nodoDoble.der = eliminarMin(nodoDoble.der);
            }
            else if (nodoDoble.izq != null) {

                nodoDoble = nodoDoble.izq;
            }
            else {
                nodoDoble = nodoDoble.der;
            }
        }
        return nodoDoble;
    }
    public boolean existe(Comparable comparable){
        return existe(root,comparable);

    }
    private boolean existe(NodoDoble nodoDoble, Comparable comparable){
        if (nodoDoble == null || nodoDoble.element == null) {return false;}
        else if (comparable.compareTo(nodoDoble.element)==0) return true;
        else if (comparable.compareTo(nodoDoble.element)<0){
            return existe(nodoDoble.izq,comparable);
        }
        else{
            return existe(nodoDoble.der,comparable);
        }
    }
    public Object buscar(Comparable comparable){  // Buscar
        if (existe(comparable)) {
           return buscar(root, comparable).element;
        }
        return null;
    }
    private NodoDoble buscar(NodoDoble root, Comparable comparable) {  // Buscar
        if (comparable.compareTo(root.element)==0) return root;
        else if (comparable.compareTo(root.element)<0){
            return buscar(root.izq, comparable);
        }
        else{
            return buscar(root.der, comparable);
        }

    }
    private NodoDoble getMin(NodoDoble nodoDoble){
        if (nodoDoble.izq != null){
            getMin(nodoDoble.izq);
        }
        return nodoDoble;
    }
    private NodoDoble getMax(NodoDoble nodoDoble){
        if (nodoDoble.der != null){
            getMax(nodoDoble.der);
        }
        return nodoDoble;
    }
    private NodoDoble eliminarMin(NodoDoble t){
        if (t.izq != null) {
            t.izq = eliminarMin(t.izq);
        }
        else {
            t = t.der;
        }
        return t;

    }
    public void enOrden(ArBinBus arBinBus) {
        if (!arBinBus.isEmpty()) {
            enOrden(arBinBus.getLeft());
            System.out.println(arBinBus.getRoot().toString());
            enOrden(arBinBus.getRight());
        }
    }
}