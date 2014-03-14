package pila;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 14/03/14
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */
public class PilaE implements Pila{
    private Object[] dato;
    private int tope;

    public  PilaE(){
        dato=new Object[20];
        tope=-1;
    }
    public void apilar(Object elemento){
        if (lleno()){
            ampliar();
        }
        tope++;
        dato[tope]=elemento;
    }
    public void desapilar(){
        tope--;
    }
    public Object verTope(){
        return dato[tope];
    }
    public void vaciar(){
        tope=-1;
    }
    public boolean esVacia(){
        if (tope==-1) return true;
        return false;
    }
    private boolean lleno(){
        if (tope== dato.length-1){
            return true;
        }
        return false;
    }
    private void ampliar(){
        Object[] dato2= new Object[dato.length+10];
        for (int i =0; i<dato.length;i++){
             dato2[i]=dato[i];
        }
        dato=dato2;
    }
}
