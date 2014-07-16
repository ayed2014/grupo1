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

    /**
     * Constructor of the class.
     * @param tableCapacity
     */
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

    /**
     * Insert a object in the table.
     * @param obj
     */
    public void insert(Object obj){
         int key = ((HashableOD)obj).hash(capacity);
         table[key].insertA(obj);

    }

    /**
     * Delete a object in the table.
     * @param obj (object given must be in the table)
     */
    public void delete(Object obj){


    }

    /**
     * Recover a object with the same key.
     * @param obj (object must be of the same type of object in the table, and the key of the object must be in the table)
     * @return obj (recovered)
     */
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

    /**
     * Method that look if the object key given, is in the table.
     * @param obj
     * @return boolean (true if exist, false if not)
     */
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

    /**
     * Return an arbinbus of the table.
     * @return
     */
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

    /**
     * Delete the table.
     */
    public void deleteTable(){

        table = null;
        capacity = 0;
    }

    /**
     * Method that return the Load Factor.
     * @return
     */
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
