package test;

import soundex.DictionaryNotFoundException;
import soundex.TableHODsoundex;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 01/06/14
 * Time: 01:18
 * To change this template use File | Settings | File Templates.
 */
public class SoundexTestHashTable {

    public static void main(String[] args) {

        TableHODsoundex table = new TableHODsoundex(6000);

        try {
            table.loadDictionary("C:\\Users\\Gustavo\\Desktop\\Programas intellij\\Tabla Hash\\src\\usefullClasses\\EnglishBasicDictionary.txt");
        } catch (DictionaryNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        String [] wordsLikeThisOne = table.recover("been");

        for (int i = 0 ; i< wordsLikeThisOne.length;i++){
            System.out.println(wordsLikeThisOne[i]);
        }



    }
}
