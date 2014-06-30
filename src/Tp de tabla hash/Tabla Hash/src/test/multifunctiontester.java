package test;

import hashTableOpenDispersion.Primo;
import soundex.Soundex;

/**
 * Created with IntelliJ IDEA.
 * User: Gustavo
 * Date: 14/06/14
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class multifunctiontester {

    public static int baseFunction(String s, int capacity){

        int char1Value = (int)s.charAt(0);
        int char2Value = (int)s.charAt(1);
        int char3Value = (int)s.charAt(2);
        int char4Value = (int)s.charAt(3);





        int  toReturn = (((char1Value*37+char2Value)*37+char3Value)*37+char4Value)% capacity;

        return toReturn;
    }

    public static void main(String[] args) {

        //System.out.println(Primo.proxPrimo(214));
        //String s = Soundex.soundex2("PTRDO");
        System.out.println( baseFunction("s530",223));
        System.out.println( baseFunction("w330",223));
    }
}
