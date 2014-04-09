package ejercicio1;




import usefulClasses.PilaE;
import usefulClasses.ColaD;




/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 04/04/14
 * Time: 01:14
 * To change this template use File | Settings | File Templates.
 */
public class Palindromo {


    public boolean isAPalindrome(String [] words){

        String a = "";
        for(int i = 0; i< words.length; i++){

          a = a+(words[i]).trim();
        }

        a=a.trim();
        a=a.toLowerCase();

        return isAPalindrome(a);
    }




    public boolean isAPalindrome(String word){
        Boolean toReturn = true;
        PilaE pila = new PilaE();
        ColaD cola = new ColaD();
        int count = 0;


            for (int i = 0; i <word.length(); i++){

               pila.apilar(word.charAt(i));

            }

            for (int i = 0; i <word.length(); i++){

                cola.enqueue(word.charAt(i));

            }

            while(count < word.length()){


                if(!cola.deQueue().equals(pila.verTope())){
                   toReturn = false;
                   break;
                }

                pila.desapilar();
                count++;
            }

        return toReturn;
    }


}
