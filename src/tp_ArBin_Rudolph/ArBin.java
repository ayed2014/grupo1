package tp_ArBin_Rudolph;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 26/03/14
 * Time: 12:25
 * To change this template use File | Settings | File Templates.
 */
public class ArBin implements Serializable {

    private NodoDoble root;

    public ArBin(){
        root=null;
    }
    public ArBin(Object elem){
        root = new NodoDoble();
        root.elem=elem;
        root.leftSon=null;
        root.rightSon= null;
    }
    public ArBin(Object elem, ArBin a1, ArBin a2){
        root= new NodoDoble();
        root.elem=elem;
        root.leftSon= a1.root;
        root.rightSon=a2.root;
    }

    public boolean isEmpty(){
       return (root==null);
    }
    public Object getRoot(){
       return root.elem;
    }
    public ArBin getLeft(){
        ArBin t= new ArBin();
        t.root= root.leftSon;
        return t;
    }
    public ArBin getRight(){
        ArBin t= new ArBin();
        t.root= root.rightSon;
        return t;
    }
}
