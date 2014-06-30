package spellingChecker;

import hashTableOpenDispersion.Primo;
import soundex.DictionaryNotFoundException;
import soundex.Soundex;
import soundex.TableHODsoundex;
import usefullClasses.ListaD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 01/06/14
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 */
public class SpellingChecker {

    private ListaD userText;
    private ListaD aux;
    private TableHODsoundex dictionary;
    private int minCapacityNumber;


    public void checkSpelling(String textURI){

        boolean areAllTheWordsInTheDictionary = true;
        userText = new ListaD();
        dictionary = new TableHODsoundex(Primo.proxPrimo(214));
        try {
            dictionary.loadDictionary("C:\\Users\\Gustavo\\Desktop\\Programas intellij\\Tabla Hash\\src\\usefullClasses\\EnglishBasicDictionary.txt");
        } catch (DictionaryNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader(textURI);
            BufferedReader buffer = new BufferedReader(fr);

            String linea;

            while ((linea = buffer.readLine()) != null){
                userText.insertA(linea);
            }


        } catch (FileNotFoundException e) {
           e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

         userText.goTo(0);

        for (int i =0; i< userText.length();i++){

            String toCompare = (String) userText.see();
            boolean exist = dictionary.exist(toCompare);

            if(!exist){
                areAllTheWordsInTheDictionary = false;
                System.out.println("The word: *" + toCompare +"* is not in the dictionary.");
                String [] possibleCorrections = dictionary.recover(toCompare);

                if (possibleCorrections.length > 0){
                    System.out.println("Possible corrections of the word *" + toCompare+"* :");

                    for (int j = 0; j<possibleCorrections.length;j++){
                        System.out.println(possibleCorrections[j]);
                    }
                }
                else {
                    System.out.println("NO possible correction found.");
                }

            }
            userText.next();
        }

        if (areAllTheWordsInTheDictionary){
            System.out.println("All the words in the text are in the dictionary");
        }


    }

    public int getTheMinOfTheDictionary(String textURI) {

        int min =  100000000;

        try {
            FileReader fr = new FileReader(textURI);
            BufferedReader buffer = new BufferedReader(fr);

            String linea;
            aux = new ListaD();
            aux.goTo(0);

            while ((linea = buffer.readLine()) != null){
                aux.insertA(linea);
            }


            aux.goTo(0);

            for (int i =0; i<aux.length();i++){

                String s = (String)aux.see();
                String soundexCode = Soundex.soundex2(s);

                String linkSoundexCode = getSoundexLinkNumbers(soundexCode);
                int linkSoundexInt = Integer.valueOf(linkSoundexCode);


                if (linkSoundexInt<min){
                    min = linkSoundexInt;
                }


                aux.next();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return min;

    }

    public int getTheMaxOfTheDictionary(String textURI) {

        int max =  0;

        try {
            FileReader fr = new FileReader(textURI);
            BufferedReader buffer = new BufferedReader(fr);

            String linea;
            aux = new ListaD();
            aux.goTo(0);

            while ((linea = buffer.readLine()) != null){
                aux.insertA(linea);
            }


            aux.goTo(0);

            for (int i =0; i<aux.length();i++){

                String s = (String)aux.see();
                String soundexCode = Soundex.soundex2(s);

                String linkSoundexCode = getSoundexLinkNumbers(soundexCode);
                int linkSoundexInt = Integer.valueOf(linkSoundexCode);


                if (linkSoundexInt>max){
                    max = linkSoundexInt;
                }


                aux.next();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return max;

    }

    private void searchMinCapacityNumber(String textURI){

        try {
            FileReader fr = new FileReader(textURI);
            BufferedReader buffer = new BufferedReader(fr);

            String linea;
            aux = new ListaD();
            aux.goTo(0);

            while ((linea = buffer.readLine()) != null){
                aux.insertA(linea);
            }


            aux.goTo(0);

            for (int i =0; i<aux.length();i++){

                String s = (String)aux.see();
                minCapacity(s,aux.length());

                aux.next();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void minCapacity(String s , int capasidad){

        if (!Primo.isPrimo(capasidad)){
            capasidad = Primo.proxPrimo(capasidad);
        }

        if ((productASCIIValuesFunction(s, capasidad)>=capasidad)){
            minCapacity(s, Primo.proxPrimo(capasidad));
        }
        else {
            if (minCapacityNumber<capasidad){
                minCapacityNumber = capasidad;
            }

        }


    }

    private int productASCIIValuesFunction (String s, int capacity){

        s = Soundex.soundex2(s);



        int toReturn=(int)s.charAt(0);



        for (int i = 1; i<s.length();i++){

            toReturn = toReturn * (int)(s.charAt(i));
        }



        return (toReturn%capacity);



    }

    public int getMinCapacityNumber(String textURI){

        searchMinCapacityNumber(textURI);

        return minCapacityNumber;
    }

    //It returns the ascii code of each char linked all together.
    private String getSoundexLinkNumbers(String soundexCode){

        int [] codigo = new int[4];

        for (int j = 0; j< soundexCode.length(); j++){

            char letra = soundexCode.charAt(j);
            codigo [j] = (int) letra;

        }

        String stringCodigo = "";

        for (int k = 0; k<codigo.length;k++){
            stringCodigo += String.valueOf(codigo[k]);
        }

        return stringCodigo;

    }

}
