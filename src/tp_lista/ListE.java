package tp_lista;

import lista.List;

/**
 * Created with IntelliJ IDEA.
 * User: rudolpha
 * Date: 04/04/14
 * Time: 09:59
 * To change this template use File | Settings | File Templates.
 */
public class ListE implements List{
    private Object[] dato;
    private int window;
    private int quantity;

    public ListE(){
        dato= new Object[10];
        window=-1;
        quantity=0;
    }
    @Override
    public void addBefore(Object elem) {
        if (isEmpty()){
            window++;
            dato[window]=elem;
        } else{
            if (quantity==dato.length-1){
                resize();
            }
            for (int i =quantity-1;i>=window;i--){
                dato[i+1]=dato[i];
            }
            dato[window]=elem;
        }
        quantity++;

    }

    @Override
    public void addNext(Object elem) {
        if (isEmpty()){
            window++;
            dato[window]=elem;
        } else{
            if (quantity==dato.length-1){
                resize();
            }
            for (int i =quantity-1;i>window;i--){
                dato[i+1]=dato[i];
            }
            dato[window+1]=elem;
            window++;
        }
        quantity++;
    }

    @Override
    public void next() {
        if (dato[window+1]!=null)
            window++;
    }

    @Override
    public void before() {
        if (dato[window-1]!=null)
            window--;
    }

    @Override
    public void goTo(int x) {
        if (dato[x]!=null)
            window=x;
    }

    @Override
    public boolean isEmpty() {
        return (dato[0]==null);
    }

    @Override
    public void empty() {
        Object[] aux=new Object[10];
        dato=aux;
        window=-1;
    }

    @Override
    public Object showWindow() {
        return dato[window];
    }

    @Override
    public void delete() {

        for (int i =window;i<quantity;i++){
            dato[i]=dato[i+1];
        }
        dato[quantity-1]=null;
        quantity--;
    }

    @Override
    public void modify(Object elem) {
        dato[window]=elem;
    }

    @Override
    public int length() {
        return quantity;
    }

    private void resize(){
        Object[] dato2= new Object[dato.length+10];
        for (int i =0; i<dato.length;i++){
            dato2[i]=dato[i];
        }
        dato=dato2;
    }
}
