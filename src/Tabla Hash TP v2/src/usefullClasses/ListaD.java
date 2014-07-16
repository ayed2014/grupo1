package usefullClasses;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 03/04/14
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class ListaD implements ListaDinamicaInterface {

    private Nodo window;
    private Nodo start;
    private int length;

    public ListaD(){
        start = null;
        window = null;
        length = 0;
        //start.sig = window;
    }

    @Override
    public void insertA(Object o) {

        if(isEmpty()){

            Nodo aux = new Nodo();
            aux.dato = o;
            start = aux;
            window = aux;
            aux.sig = aux;


        }

        else {
            Nodo aux = new Nodo();
            aux.dato = o;
            window.sig = aux;
            window = aux;

        }


        length ++;
    }

    @Override
    public void insertD(Object o) {

        Nodo aux = new Nodo();
        aux.dato = o;
        aux.sig = window.sig;




    }

    @Override
    public void next() {
       window = window.sig;
    }

    @Override
    public void last() {
       // super.last();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void goTo(int position) {
        for (int i = 0 ; i< position;i++){

            window = start.sig;
        }
        if(position == 0){
            window = start;
        }
    }

    @Override
    public void delete() {

        length--;
    }

    @Override
    public Object see() {
      return window.dato;

    }

    @Override
    public void vaciar() {
        //super.vaciar();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public Boolean isEmpty() {
        return (start == null);

    }


    @Override
    public void modify(Object o) {
        //super.modify(o);    //To change body of overridden methods use File | Settings | File Templates.
    }


    @Override
    public int length() {
        return length;
    }

    public void goToTheFirstPosition(){
        window = start;
    }

}
