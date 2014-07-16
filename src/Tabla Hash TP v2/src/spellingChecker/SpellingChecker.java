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

    /**
     * This method is the spelling checker, it shows the possibles spelling corrections of a text given.
     * @param textURI (String URI of the text)
     */
    public void checkSpelling(String textURI){
        boolean areAllTheWordsInTheDictionary = true;
        userText = new ListaD();
        dictionary = new TableHODsoundex(Primo.proxPrimo(214));
        try {

            //  IMPORTANT: If it is execute in another machine the  path MUST be change.

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

}
