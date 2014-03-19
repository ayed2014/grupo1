package tp_pila;
/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 18/03/14
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class PilaE implements Pila {

    private Object[] dato;
    private int tope;

    public PilaE(int capacidad){
        dato=new Object[capacidad];
        tope=-1;
    }

    public PilaE(){
        this(10);
    }

    @Override
    public void apilar(Object elemento) {
        if (lleno()){
            ampliar();
        }
        tope++;
        dato[tope]=elemento;
    }

    @Override
    public void desapilar() {
        tope--;
    }

    @Override
    public void vaciar() {
        tope=-1;
    }

    @Override
    public Object verTope() {
        return dato[tope];
    }

    @Override
    public boolean esVacia() {
        if(tope==-1) return true;
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
