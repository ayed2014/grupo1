package hashTableOpenDispersion;

import usefullClasses.*;
import usefullClasses.Comparable;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 31/05/14
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
public class TableHOD {

    private ListaD [] table;
    private int capacity;

    public TableHOD(int tableCapacity){

         if(!Primo.isPrimo(tableCapacity)){

             tableCapacity = Primo.proxPrimo(tableCapacity);
             capacity = tableCapacity;
         }

        table = new ListaD[capacity];

        for (int i = 0; i < capacity; i++){
            table[i] = new ListaD();
        }
    }

    //object given must not be in the table.
    //BE CAREFUL WITH THE insertA METHOD, I DO NOT KNOW IF IT IS OK.
    public void insert(Object obj){
         int key = ((HashableOD)obj).hash(capacity);
         table[key].insertA(obj);

    }

    //object given must be in the table.
    public void delete(Object obj){


    }

    //object must be of the same type of object in the table, and the key of the object must be in the table.
    public Object recover(Object obj){

        int key = ((HashableOD)obj).hash(capacity);
        table[key].goToTheFirstPosition();

        int length = table[key].length();

        for (int i = 0; i < length; i++){

            if(((usefullClasses.Comparable) obj).compareTo(table[key]) == 0){
                return table [key].see();
            }
            else table[key].next();
        }

        return obj;
    }

    //object must be of the same type of object in the table, and the object must have a key of the same type.

    public Boolean exist(Object obj){

        int key = ((HashableOD)obj).hash(capacity);
        table[key].goToTheFirstPosition();

        int length = table[key].length();

        for (int i = 0; i < length; i++){

            if (((Comparable)obj).compareTo(table[key])== 0){
                return true;
            }
            else table[key].next();
        }

        return false;
    }

    public ArBinBus getArBinBus (){

        ArBinBus a = new ArBinBus();

        for (int i = 0; i < capacity; i++){

            if (!table[i].isEmpty()){
                table[i].goToTheFirstPosition();

                for (int j = 0; j < table[i].length(); j++){

                    a.insertar((Comparable)table[i].see());
                    table[i].next();
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

    public float getLoadFactor(){

        int totalKeys = 0;

        for (int i = 0 ; i<capacity;i++ ){

            totalKeys +=table[i].length();
        }

        if (totalKeys==0){
            return 0;
        }
        return totalKeys/capacity;
    }








}
