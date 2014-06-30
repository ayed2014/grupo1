package hashTableCloseDispersion;
import hashTableOpenDispersion.HashableOD;
import usefullClasses.ListE;
import usefullClasses.ArBinBus;
import usefullClasses.Comparable;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 31/05/14
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
public class TableHCD {

    private ListE table;
    private int capacity;

    public void TableH(int tableCapacity){

        table = new ListE(tableCapacity);
        capacity = tableCapacity;
    }

    //object given must not be in the table.
    //BE CAREFUL WITH THE insertA METHOD, I DO NOT KNOW IF IT IS OK.
    public void insert(Object obj){
        int key = ((HashableCD)obj).hash(capacity);

        table.goTo(key);

        while (key <capacity && table.showWindow()!= null){
          key +=1;
          table.goTo(key);

        }
        if (table.showWindow() != null){
            reDispersion();
            insert(obj);
        }
        else {
            table.before();
            table.addNext(obj);
        }



    }

    //object given must be in the table.
    public void delete(Object obj){


    }

    //object must be of the same type of object in the table, and the key of the object must be in the table.
    public Object recover(Object obj){

        int key = ((HashableCD)obj).hash(capacity);
        table.goTo(key);

        if(((Comparable) obj).compareTo(table.showWindow()) == 0){
            return table.showWindow();
        }
        else {

            while (key<capacity){
                if(((Comparable) obj).compareTo(table.showWindow()) == 0){
                    return table.showWindow();
                }
                else key +=1;
            }
            return obj;
        }



    }

    //object must be of the same type of object in the table, and the object must have a key of the same type.

    public Boolean exist(Object obj){

        int key = ((HashableOD)obj).hash(capacity);
        table.goTo(key);

        if(((Comparable) obj).compareTo(table.showWindow()) == 0){
            return true;
        }
        else {

            while (key<capacity){
                if(((Comparable) obj).compareTo(table.showWindow()) == 0){
                    return true;
                }
                else key +=1;
            }
            return false;
        }
    }

    public ArBinBus getArBinBus (){

        ArBinBus a = new ArBinBus();

        for (int i = 0; i < capacity; i++){

            if (!table.isEmpty()){
                table.goTo(0);

                for (int j = 0; j < table.length(); j++){

                    a.insertar((Comparable) table.showWindow());
                    table.next();
                    j++;
                }
            }
        }

        return a;
    }

    public void deleteTable(){

        table = null;
        capacity = 0;



    }

    private void reDispersion(){
        ListE aux = new ListE(capacity*2);

        Object [] elements = getElements();

        for (int i = 0; i < elements.length;i++){

            int key = ((HashableCD)elements[i]).hash(capacity*2);
            aux.goTo(key);

            while (aux.showWindow()!=null){
                aux.goTo(key+1);
            }

            aux.addNext(elements[i]);

        }

        table = aux;

    }

    private Object [] getElements(){
        Object [] toReturn = new Object[capacity];

        int index =0;
       while (index<capacity){
           table.goTo(index);
           toReturn[index] = table.showWindow();
           index+=1;
       }
        return toReturn;
    }






}
