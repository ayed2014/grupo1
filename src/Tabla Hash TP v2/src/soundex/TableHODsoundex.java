package soundex;

import hashTableOpenDispersion.Primo;
import usefullClasses.*;

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

    /**
     * Constructor of the class.
     * @param tableCapacity
     */
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

    /**
     * Method that insert a string to the dictionary (dictionary I call to this class)
     * @param s
     */
    public void insert(String s){

        String stringKey = Soundex.soundex(s);
        int intKey = sumASCIIValuesFunction(stringKey);
        table[intKey].insertA(s);
    }

    /**
     * Delete a object in the table.
     * @param obj (object given must be in the table)
     */
    public void delete(Object obj){


    }

    /**
     * Recover an array of strings with the same key.
     * @param s (String)
     * @return  String (recovered)
     */
    public String[] recover(String s){
        String stringKey = Soundex.soundex(s);
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

    /**
     * Method that look if the String key given, is in the table.
     * @param s
     * @return boolean (true if exist, false if not)
     */
    public Boolean exist(String s){
        String stringKey = Soundex.soundex(s);
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

    /**
     * Return an arBinBus of the table.
     * @return
     */
    public ArBinBus getArBinBus (){
        ArBinBus a = new ArBinBus();
        for (int i = 0; i < capacity; i++){
            if (!table[i].isEmpty()){
                table[i].goToTheFirstPosition();
                for (int j = 0; j < table[i].length(); j++){
                    a.insertar((usefullClasses.Comparable)table[i].see());
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
     * Method that loads a Dictionary.
     * @param dictionaryURI
     * @throws DictionaryNotFoundException
     */
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

    /**
     * Method that represent a dispersal function apply to the soundex code previous calculate (Sum ASCCI values).
     * @param s
     * @return int
     */
    private int sumASCIIValuesFunction (String s){
        int toReturn=(int)s.charAt(0);
        for (int i = 1; i<s.length();i++){
            toReturn = toReturn * (int)(s.charAt(i));
        }
        return toReturn%capacity;

    }

    /**
     * Method that represent a dispersal function apply to the soundex code previous calculate (base).
     * @param s
     * @return int ()
     */
    private int baseFunction(String s, int capacity){
        int char1Value = (int)s.charAt(0);
        int char2Value = (int)s.charAt(1);
        int char3Value = (int)s.charAt(2);
        int char4Value = (int)s.charAt(3);
        int  toReturn = (((char1Value*37+char2Value)*37+char3Value)*37+char4Value)% capacity;
        return toReturn;
    }










}
