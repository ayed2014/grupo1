package soundex;

import hashTableOpenDispersion.HashableOD;
import hashTableOpenDispersion.Primo;
import usefullClasses.ArBinBus;
import usefullClasses.Comparable;
import usefullClasses.ListaD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 31/05/14
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
public class TableHODsoundex {

    private ListaD [] table;
    private int capacity;

    public TableHODsoundex(int tableCapacity){

         if(!Primo.isPrimo(tableCapacity)){

             tableCapacity = Primo.proxPrimo(tableCapacity);
             capacity = tableCapacity;
         }
        else {
             capacity =tableCapacity;
         }


        table = new ListaD[capacity];

        for (int i = 0; i < capacity; i++){
            table[i] = new ListaD();
        }
    }

    //object given must not be in the table.
    //BE CAREFUL WITH THE insertA METHOD, I DO NOT KNOW IF IT IS OK.
    public void insert(String s){
        /**
         int key = Soundex.soundex(s);
         table[key].insertA(s);
           **/

        String stringKey = Soundex.soundex2(s);
        int intKey = sumASCIIValuesFunction(stringKey);
        table[intKey].insertA(s);
    }

    //object given must be in the table.
    public void delete(Object obj){


    }

    //object must be of the same type of object in the table, and the key of the object must be in the table.
    public String[] recover(String s){

        /**
        int key = Soundex.soundex(s);
        table[key].goTo(0);


        int length = table[key].length();
        String [] toReturn = new String[length];

         int length = table[key].length();
         String [] toReturn = new String[length];


         for (int i = 0; i < length; i++){

         toReturn[i] = (String)table[key].see();

         table[key].next();
         }

         **/

        String stringKey = Soundex.soundex2(s);
        //int intKey = sumASCIIValuesFunction(stringKey);
        int intKey = baseFunction(stringKey,capacity);
        table[intKey].goTo(0);


        int length = table[intKey].length();
        String [] toReturn = new String[length];


        for (int i = 0; i < length; i++){

            toReturn[i] = (String)table[intKey].see();

            table[intKey].next();
        }

        return toReturn;
    }

    //object must be of the same type of object in the table, and the object must have a key of the same type.

    public Boolean exist(String s){

        /**
        int key = Soundex.soundex(s);
        table[key].goToTheFirstPosition();

        int length = table[key].length();

        for (int i = 0; i < length; i++){

            if ((s.compareTo((String)table[key].see()))== 0){
                return true;
            }
            else table[key].next();
        }
         **/

        String stringKey = Soundex.soundex2(s);
        int key = sumASCIIValuesFunction(stringKey);
        table[key].goToTheFirstPosition();

        int length = table[key].length();

        for (int i = 0; i < length; i++){

            if ((s.compareTo((String)table[key].see()))== 0){
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

    public void loadDictionary(String dictionaryURI)throws DictionaryNotFoundException{

        try {
            FileReader fr = new FileReader(dictionaryURI);
            BufferedReader buffer = new BufferedReader(fr);

            String linea;

            while ((linea = buffer.readLine()) != null){
               insert(linea);
            }


        } catch (FileNotFoundException e) {
            throw new DictionaryNotFoundException();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //Dispersion function apply to the soundex code previous calculate.
    /**
    private int sumASCIIValuesFunction (String s){

        int toReturn = 0;

        for (int i = 0; i<s.length();i++){

            toReturn += (int)(s.charAt(i));
        }

       return toReturn%capacity;

    }
     **/

    private int sumASCIIValuesFunction (String s){

        int toReturn=(int)s.charAt(0);

        for (int i = 1; i<s.length();i++){

            toReturn = toReturn * (int)(s.charAt(i));
        }

        return toReturn%capacity;

    }

    private int baseFunction(String s, int capacity){

        int char1Value = (int)s.charAt(0);
        int char2Value = (int)s.charAt(1);
        int char3Value = (int)s.charAt(2);
        int char4Value = (int)s.charAt(3);





        int  toReturn = (((char1Value*37+char2Value)*37+char3Value)*37+char4Value)% capacity;

        return toReturn;
    }










}
