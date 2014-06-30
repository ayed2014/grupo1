package usefullClasses;

import soundex.DictionaryNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 01/06/14
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
public class AnalizeDictionary {

    char [] validateLetters = {'B','F','P','V','C','G','J','K','Q','S','X','Z','D','T','L','M','N','R'};

    public void analize(String dictionaryURI){


        try {
            FileReader fr = new FileReader(dictionaryURI);
            BufferedReader buffer = new BufferedReader(fr);

            String linea;

            while ((linea = buffer.readLine()) != null && (linea = buffer.readLine()) !="" ){

                boolean validateWord = false;
                linea = linea.toUpperCase();

                for (int i = 0; i<linea.length();i++){


                    for (int j =0; j<validateLetters.length;j++){

                        if (linea.charAt(i) == validateLetters[j]){
                            validateWord = true;
                            break;
                        }
                    }

                }

                if (validateWord == false){
                    System.out.println(linea);
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
